package com.leo.fly.baidu;

import com.leo.fly.baidu.utils.HttpUtil;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.util.Base64;

@Controller
@RequestMapping("/baidu-ocr")
public class BaiduOCRController {
    @ResponseBody
    @PostMapping("/accurate")
    public JsonResult accurate(@Param("file") MultipartFile file){
        System.out.println(file);
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate";
        try {
            String imgStr = Base64.getEncoder().encodeToString(file.getBytes());
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.03cb2646480001a155d4b0f36037ff17.2592000.1659439824.282335-26611729";
            String result = HttpUtil.post(url, accessToken, param);
            return JsonResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(ErrorCodeEnum.E_OTHERS);
        }
    }
}
