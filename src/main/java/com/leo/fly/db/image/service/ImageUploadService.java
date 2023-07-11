package com.leo.fly.db.image.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class ImageUploadService {
    @Value("${file.photo.dir}")
    private String realPath;
    @Autowired
    ImageService imageService;


    @SneakyThrows
    public Image uploadImage(MultipartFile img, Long code, String moduleType) {
        String originalFilename = img.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        LambdaQueryWrapper<Image> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.select(Image::getId).eq(Image::getCode,code).eq(Image::getName,originalFilename);
        List<Image> list = imageService.list(queryWrapper);
        //1.处理头像的上传&修改文件名称
        //1.1时间戳作为文件名前缀
        if(ObjectUtils.isNotEmpty(list)) {
            throw new ComException(ErrorCodeEnum.E_FILE_EXISTS);
        }
        String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        //1.3拼接成新的文件名
        File file = new File(realPath + code);
        if(!file.exists()) {
            file.mkdir();
        }
        Image image = save(moduleType, code, originalFilename,fileType);
        img.transferTo(new File(file.getPath(),image.getId()+fileNameSuffix));
        return image;
    }

    private Image save(String type,Long productId,String originalFilename,String fileType) {
        Image image = new Image();
        image.setType(type);
        image.setCode(""+productId);
        image.setPath(realPath+productId);
        image.setName(originalFilename);
        image.setStatus(0);
        image.setIsMain(false);
        image.setFileType(fileType);
        imageService.save(image);
        return image;
    }
}
