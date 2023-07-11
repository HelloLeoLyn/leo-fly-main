package com.leo.fly.python.controller;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.python.components.GenerateGoodsImage;
import com.leo.fly.python.components.ImageStandardPsComponent;
import com.leo.fly.python.params.PythonImageCutParams;
import com.leo.fly.python.params.PythonImageGoodsParams;
import com.leo.fly.python.params.PythonImageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/python/image")
public class PythonImageController {
    @Autowired
    ImageStandardPsComponent imageStandardPsComponent;

    @Autowired
    GenerateGoodsImage generateGoodsImage;
    @Autowired
    ImageService imageService;
    @Value("${file.python.dir}")
    String pythonPath;
    @PostMapping("/stander")
    public JsonResult stander(@RequestBody PythonImageParams imageParams) {
        imageStandardPsComponent.execute(imageParams);
        return JsonResult.success();
    }


    @PostMapping("/goods")
    public JsonResult goods(@RequestBody PythonImageGoodsParams params) {
        generateGoodsImage.execute(params);
        return JsonResult.success();
    }

    @PostMapping("/rembg")
    public JsonResult rembg (@RequestBody PythonImageCutParams params) {
        Image image = imageService.getById(params.getImageId());
        String[] list = new String[5];
        list[0] = "python";
        list[1] = pythonPath+"leo_image_rembg.py";
        list[2] = params.getFileType();
        list[3] = params.getInputPath();
        list[4] = params.getOutPath();
        try {
            Process proc = Runtime.getRuntime().exec(list);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                try{
                    JSONObject msg = JSONObject.parseObject(line);
                    if("ok".equals(msg.getString("msg"))) {
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.success();
    }

}
