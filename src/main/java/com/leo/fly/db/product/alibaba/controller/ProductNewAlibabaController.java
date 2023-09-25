package com.leo.fly.db.product.alibaba.controller;

import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.alibaba.product.param.AlibabaNewProductAddParam;
import com.alibaba.product.param.AlibabaNewProductAddResult;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaNewParam;
import com.leo.fly.db.product.alibaba.service.ProductAlibabaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product/new/alibaba")
public class ProductNewAlibabaController {
    @Autowired
     ProductAlibabaService productAlibabaService;
    @PostMapping(value = "/schema")
    public JsonResult getSchema(@RequestBody ProductAlibabaNewParam params){
        if(SingletonAccessToken.getAccessToken()==null){
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
        SDKResult execute;
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
    }

    @PostMapping(value="/add/productId")
    public JsonResult sendToAlibaba(@Valid @RequestBody AlibabaNewProductAddParam params, @PathVariable Long productId) {
        if(SingletonAccessToken.getAccessToken()==null){
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
        SDKResult<AlibabaNewProductAddResult> execute;
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
        AlibabaNewProductAddResult result = execute.getResult();
        String dataJson = result.getResult().getBizData().getDataJson();
//        productAlibabaService.get();
        return  JsonResult.success(execute);
    }
}
