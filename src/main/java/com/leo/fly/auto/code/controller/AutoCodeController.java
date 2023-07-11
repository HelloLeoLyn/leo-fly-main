package com.leo.fly.auto.code.controller;

import com.leo.fly.auto.code.components.GenerateCodeComponent;
import com.leo.fly.auto.code.params.GenerateCodeParam;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/auto/code")
public class AutoCodeController {
    @Autowired
    GenerateCodeComponent generateCodeComponent;
    @PostMapping("/generate")
    public JsonResult generate(@Valid @RequestBody GenerateCodeParam param) {
        return JsonResult.success(generateCodeComponent.execute(param));
    }

    @GetMapping({"","/template"})
    public JsonResult get(@RequestParam("filePath") String filePath, @RequestParam("fileName") String fileName) {
        try {
            File file = new File(filePath,fileName);
            if(file.exists()){
                String utf8 = FileUtils.readFileToString(file, Charset.forName("UTF8"));
                return JsonResult.success(utf8);
            }else {
                throw new ComException(ErrorCodeEnum.E_FILE_NOT_EXISTS);
            }
        } catch (Exception e) {
            throw new ComException(ErrorCodeEnum.E_FILE_IS_NOT_FILE);
        }
    }


}
