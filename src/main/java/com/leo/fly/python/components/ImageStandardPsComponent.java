package com.leo.fly.python.components;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.python.params.PythonImageParams;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ImageStandardPsComponent {
    @Autowired
    ImageService imageService;
    @Value("${file.python.dir}")
    String pythonPath;
    @SneakyThrows
    @Async
    public void execute(PythonImageParams pythonImageParams) {
        String[] list;
        if (ObjectUtils.isNotEmpty(pythonImageParams.getImages())) {
            list = new String[8+pythonImageParams.getImages().size()];
            list[0] = "python";
            list[1] = pythonPath + "standard_better copy.py";
            list[2] = pythonImageParams.getWhite() ? "1" : "0";
            list[3] = pythonImageParams.getMiniLogo() ? "1" : "0";
            list[4] = pythonImageParams.getCenterLogo() ? "1" : "0";
            list[5] = pythonImageParams.getLarge() ? "1" : "0";
            list[6] = pythonImageParams.getMiddle() ? "1" : "0";
            list[7] = pythonImageParams.getMini() ? "1" : "0";
            for (int i = 0; i < pythonImageParams.getImages().size(); i++) {
                list[i + 8] = pythonImageParams.getImages().get(i).getPath();
            }
            try {
                Process proc = Runtime.getRuntime().exec(list);// 执行py文件
                BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    try{
                        JSONObject object = JSONObject.parseObject(line);
                        Integer index = object.getInteger("index");
                        Image image = pythonImageParams.getImages().get(index);
                        image.setType("111111");
                        imageService.updateById(image);
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
        } else {
            return;
        }
    }

}
