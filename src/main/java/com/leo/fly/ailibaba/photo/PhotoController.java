package com.leo.fly.ailibaba.photo;


import com.alibaba.ocean.rawsdk.client.APIId;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.image.entity.Image;
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

    @PostMapping(value = "/uploadOne")
    @ResponseBody
    public JsonResult uploadOne(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Long albumID) throws IOException {
        PhotoBankParams param = new PhotoBankParams();
        param.setOceanApiId(new APIId("com.alibaba.product", "alibaba.photobank.photo.add", 1));
        param.setAlbumID(albumID);
        param.setDrawTxt(false);
        param.setImageBytes(file.getBytes());
        param.setWebSite("1688");
        param.setName(file.getOriginalFilename());
        PhotoBankPhotoResult photoBankPhotoResult = photoService.photo(param);
        return JsonResult.success(photoBankPhotoResult.getImage());
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
