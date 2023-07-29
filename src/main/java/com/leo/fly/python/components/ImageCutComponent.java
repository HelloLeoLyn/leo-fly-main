package com.leo.fly.python.components;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.python.params.PythonImageCutParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageCutComponent {
    @Autowired
    ImageService imageService;
    @Value("${file.python.dir}")
    String pythonPath;
    @Value("${file.photo.dir}")
    String imageBaseDir;

    @Async
    public void execute(PythonImageCutParams pythonImageParams) {
        Image image;
        if (pythonImageParams.getGenerateType().equals("new")) {
            image = getImage(pythonImageParams);

        } else {
            image = imageService.getById(pythonImageParams.getImageId());
        }
        List<String> list = new ArrayList<>();
        list.add("python");
        list.add(pythonPath + "leo_image_chongzu.py");
        list.add(pythonImageParams.getPath());
        list.add(imageBaseDir + pythonImageParams.getProductId());
        list.add(image.getId() + "");
        list.add(pythonImageParams.isSize300() ? "1" : "0");
        list.add(pythonImageParams.isSize50() ? "1" : "0");
        list.add(pythonImageParams.isFillWhiteBG() ? "1" : "0");
        list.add(".jpg");
        list.add(pythonImageParams.isLeftLogo() ? "1" : "0");
        list.add(pythonImageParams.isBgWater() ? "1" : "0");
        list.add(pythonImageParams.getOptionType());
        try {
            String[] array = list.toArray(new String[list.size()]);
            Process proc = Runtime.getRuntime().exec(array);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                try {
                    JSONObject object = null;
                    object = JSONObject.parseObject(line);
                    if (object.getString("code").equals("ok")) {
                        image.setName(image.getId() + image.getFileType());
                        image.setPath(imageBaseDir + pythonImageParams.getProductId() + "/" + image.getId()+image.getFileType());
                        imageService.updateById(image);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            in.close();
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Image getImage(PythonImageCutParams pythonImageParams) {
        Image image = new Image();
        image.setCode(pythonImageParams.getProductId() + "");
        image.setName("");
        image.setPath("");
        image.setFileType(".jpg");
        image.setPixel("1000*1000");
        image.setType("PE");
        image.setStatus(1);
        imageService.save(image);
        return image;
    }

}
