package com.leo.fly.ailibaba.video;

import com.alibaba.multimedia.param.AlibabaVideoVideocenterUploadResult;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/video/alibaba")
@Slf4j
public class VideoController {
    @ResponseBody
    @PostMapping("/preUpload")
    public JsonResult preUpload(){
        return JsonResult.success();
    }

    @ResponseBody
    @PostMapping("/upload")
    public JsonResult upload(@RequestParam MultipartFile file,@RequestParam String fileName,@RequestParam String description){
        try {
            InputStream inputStream = file.getInputStream();
            VideoParams params = new VideoParams();
            params.setFileData(inputStream);
            params.setFileName(fileName);
            params.setDescription(description);
            if(SingletonAccessToken.getAccessToken()==null){
                throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
            }
            SDKResult<AlibabaVideoVideocenterUploadResult> execute;
            if (SingletonAccessToken.getAccessToken().getToken() != null) {
                AccessToken accessToken = SingletonAccessToken.getAccessToken();
                ApiExecutor apiExecutor = accessToken.getApiExecutor();
                execute = apiExecutor.execute(params, accessToken.getToken().getAccess_token());
                if (StringUtils.isNotBlank(execute.getErrorMessage())) {
                    throw new ComException(ErrorCodeEnum.E_OTHERS, execute.getErrorMessage());
                }
            }else{
                throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
            }
            return  JsonResult.success(execute);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
