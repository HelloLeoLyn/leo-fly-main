package com.leo.fly.ailibaba.photo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.AlibabaConst;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.web.util.UserContextHolder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    ProductService productService;
    @Autowired
    ImageService imageService;

    @Override
    public PhotoBankAlbumResult album(PhotoBankAlbumParams params) {
        if(SingletonAccessToken.getAccessToken()==null){
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
        SDKResult<PhotoBankAlbumResult> execute = sentToAlibaba(params);
        return execute.getResult();
    }

    @Override
    public PhotoBankPhotoResult photo(PhotoBankParams param) {
        if(SingletonAccessToken.getAccessToken()==null){
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
        SDKResult<PhotoBankPhotoResult> execute = sentToAlibaba(param);
        return execute.getResult();
    }

    @Override
    public List<PhotoBankPhotoResult> sendImagesToAlibaba(List<Image>images, Long albumID) {
        List<PhotoBankPhotoResult> results = new ArrayList<>();
        images.forEach((image) -> {
            image = imageService.getById(image.getId());
            if (StringUtils.isNotBlank(image.getUrl())) {
                return;
            }
            PhotoBankParams param = new PhotoBankParams();
            param.setOceanApiId(new APIId("com.alibaba.product", "alibaba.photobank.photo.add", 1));
            param.setAlbumID(albumID);
            param.setDrawTxt(false);
            File file = new File(image.getPath());
            if (file.exists()) {
                try {
                    byte[] bytes = FileUtils.readFileToByteArray(file);
                    param.setImageBytes(bytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                param.setWebSite("1688");
                param.setName(image.getName());
                SDKResult<PhotoBankPhotoResult> sdkResult = sentToAlibaba(param);
                PhotoBankPhotoResult result = sdkResult.getResult();
                image.setUrl("https://cbu01.alicdn.com/" + result.getImage().getUrl());
                image.setStatus(2);
                if (image.getId() != null) {
                    imageService.updateById(image);
                }
                results.add(result);
            }
        });
        return results;
    }
    private SDKResult sentToAlibaba(AbstractAPIRequest params) {
        SDKResult execute;
        if (SingletonAccessToken.getAccessToken().getToken() != null) {
            AccessToken accessToken = SingletonAccessToken.getAccessToken();
            ApiExecutor apiExecutor = accessToken.getApiExecutor();
            execute = apiExecutor.execute(params, accessToken.getToken().getAccess_token());
            if (StringUtils.isNotBlank(execute.getErrorMessage())) {
                throw new ComException(ErrorCodeEnum.E_OTHERS, execute.getErrorMessage());
            }
        }else{
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
        return execute;
    }
}
