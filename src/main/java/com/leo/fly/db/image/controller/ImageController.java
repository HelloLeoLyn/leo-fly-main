package com.leo.fly.db.image.controller;


import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.form.ImageQueryForm;
import com.leo.fly.db.image.form.ImageQueryParam;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.image.service.ImageUploadService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 图片表 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    ImageUploadService uploadService;
    @Value("${file.photo.dir}")
    String imageBaseDir;
    @PutMapping()
    public JsonResult update(@RequestBody Image image) {
        return JsonResult.success(imageService.updateById(image));
    }

    @PutMapping("/batch")
    public JsonResult updateBatch(@RequestBody List<Image> images) {
        return JsonResult.success(imageService.updateBatchById(images));
    }

    @PostMapping()
    public JsonResult add(@RequestBody Image image) {
        return JsonResult.success(imageService.save(image));
    }

    @PostMapping(value="/page")
    public JsonResult page(@RequestBody ImageQueryForm queryForm) {
        return JsonResult.success(imageService.page(queryForm.getPage(),queryForm.toParam(ImageQueryParam.class)));
    }

    @GetMapping(value="/code/{code}")
    public JsonResult getByCode(@PathVariable String code ) {
        return JsonResult.success(imageService.getByCode(code,1));
    }

    @DeleteMapping(value = "/{id}")
    public JsonResult removeImage(@PathVariable Long id) {
//        imageService.removeById(id);
        Image image = imageService.getById(id);
        imageService.updateById(image.setStatus(-1));
        return JsonResult.success();
    }

    @PostMapping(value = "/upload")
    public JsonResult upload(@RequestParam MultipartFile file, @RequestParam Long id, @RequestParam String type) {
        return JsonResult.success(uploadService.uploadImage(file, id, type));
    }

    @GetMapping(value = "/local")
    public JsonResult localImage(){
        Collection<File> files = FileUtils.listFiles(new File(imageBaseDir+"TEMP/100APPLE"),null,true);
        return JsonResult.success(files);
    }

    @PostMapping(value = "/fail")
    public JsonResult fail(@RequestBody List<String> filepath) throws IOException {
        File dir = new File(imageBaseDir+"TEMP/fail");
        for (String src: filepath){
            File srcFile = new File(src);
            FileUtils.moveToDirectory(srcFile,dir,true);
        }
        return JsonResult.success();
    }
}

