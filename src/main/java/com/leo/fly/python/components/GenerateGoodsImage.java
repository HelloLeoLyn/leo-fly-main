package com.leo.fly.python.components;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.python.params.PythonImageGoodsParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenerateGoodsImage {
    @Autowired
    ImageService imageService;
    @Value("${file.photo.dir}")
    String imageBaseDir;
    @Value("${file.python.dir}")
    String pythonPath;

    public JSONObject execute(PythonImageGoodsParams param) {
        List<String> list = new ArrayList<>();
//        String[] list = new String[8];
        list.add("python");
        list.add(pythonPath+"generateGoodsImages.py");
        list.add(param.getCoverPath());
        list.add(param.getCoverPart());
        list.add(param.getCoverCode());
        list.add(param.getCoverSavePath());
        list.add(param.getOpt());
        list.add(param.getProductId());
        list.add(param.getIsRmbg()?"1":"0");
        list.add(imageBaseDir + param.getProductId()+"/" + param.getProductId()+"/temp.png");
        JSONObject object = null;
        try {
//            System.out.println(JSONObject.toJSONString(list));
            Process proc = Runtime.getRuntime().exec(list.toArray(new String[list.size()]));// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                try{
                    object = JSONObject.parseObject(line);
                    if(object.getString("code").equals("ok")){
                        if(param.getImageId()==null){
                            Image image = new Image();
                            image.setCode(param.getProductId());
                            image.setName(param.getName());
                            image.setPath(param.getCoverSavePath());
                            image.setFileType(".png");
                            image.setPixel("1000*1000");
                            image.setType("PE");
                            image.setStatus(1);
                            imageService.save(image);
                        }
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
        }finally {
            return object;
        }
    }
}
