package com.leo.fly.ailibaba.photo;


import com.alibaba.ocean.rawsdk.client.APIId;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/photo/alibaba")
@Slf4j
public class PhotoController {
    @Autowired
    PhotoService photoService;
    @Autowired
    ImageService imageService;
    @PostMapping(value = "/uploadOne")
    @ResponseBody
    public JsonResult uploadOne(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Long albumID, Long imageId) throws IOException {
        Image image = imageService.getById(imageId);
        if(image==null){
            throw new ComException(ErrorCodeEnum.E_NO_RECORD);
        }
        PhotoBankParams param = new PhotoBankParams();
        param.setOceanApiId(new APIId("com.alibaba.product", "alibaba.photobank.photo.add", 1));
        param.setAlbumID(albumID);
        param.setDrawTxt(false);
        param.setImageBytes(file.getBytes());
        param.setWebSite("1688");
        param.setName(file.getOriginalFilename());
        PhotoBankPhotoResult photoBankPhotoResult = photoService.photo(param);
        PhotoBankImage image1 = photoBankPhotoResult.getImage();
        image.setUrl(image1.getUrl());
        imageService.save(image);
        return JsonResult.success(image1);
    }

    @PostMapping(value = "/upload/batch")
    @ResponseBody
    public JsonResult uploadBatch(@RequestBody PhotoBankParams photoBankParams) {
        List<PhotoBankPhotoResult> photoBankPhotoResults = photoService.sendImagesToAlibaba(photoBankParams.getImages(),photoBankParams.getAlbumID());
        return JsonResult.success(photoBankPhotoResults);
    }

    @PostMapping(value = "/album")
    @ResponseBody
    public JsonResult album(@RequestBody PhotoBankAlbumParams param) {
        PhotoBankAlbumResult result = photoService.album(param);
        return JsonResult.success(result);
    }
}
