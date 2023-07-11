package com.leo.fly.file.controller;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.file.param.FileParam;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    ImageService imageService;
    @ResponseBody
    @GetMapping
    public JsonResult get(@RequestBody FileParam fileParam) throws IOException {
        File file = new File(fileParam.getFilepath(),fileParam.getFilename());
        String string = FileUtils.readFileToString(file, "UTF8");
        return JsonResult.success(string);
    }

    @ResponseBody
    @PostMapping("/exists")
    public JsonResult exists(@RequestBody FileParam fileParam){
        File file = new File(fileParam.getFilepath(),fileParam.getFilename());
        return JsonResult.success(file.exists());
    }

    @ResponseBody
    @PostMapping("/upload")
    public JsonResult upload(@Param("file")MultipartFile file){
        return JsonResult.success(file);
    }


}
