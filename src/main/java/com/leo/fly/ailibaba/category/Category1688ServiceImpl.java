package com.leo.fly.ailibaba.category;

import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;

import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Category1688ServiceImpl  implements Category1688Service {

    @Override
    public CategoryAttributeGetResult getAttributes1688(CategoryAttributeGetParam param) {
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        if (accessToken.getToken() != null) {
            SDKResult<CategoryAttributeGetResult> execute = accessToken.getApiExecutor().execute(param, accessToken.getToken().getAccess_token());
            return execute.getResult();
        }
        throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
    }

    @Override
    public CategoryGetResult get1688(Long id) {
        CategoryGetParam param = new CategoryGetParam();
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        if (accessToken.getToken() != null) {
            param.setCategoryID(id);
            SDKResult<CategoryGetResult> execute = accessToken.getApiExecutor().execute(param, accessToken.getToken().getAccess_token());
            CategoryGetResult result = execute.getResult();
            return result;
        }
        throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
    }

    @Override
    public UserDefineCategoryAddResult add1688(UserDefineCategoryAddParam addParam) {
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        if (accessToken.getToken() != null) {
            SDKResult<UserDefineCategoryAddResult> execute = accessToken.getApiExecutor().execute(addParam, accessToken.getToken().getAccess_token());
            return execute.getResult();
        }
        throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
    }

    @Override
    public CategorySearchByKeywordResult search(String keyword) {
        CategorySearchByKeywordParam param = new CategorySearchByKeywordParam();
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        if (accessToken.getToken() != null) {
            param.setKeyword(keyword);
            SDKResult<CategorySearchByKeywordResult> execute = accessToken.getApiExecutor().execute(param, accessToken.getToken().getAccess_token());
            CategorySearchByKeywordResult result = execute.getResult();
            return result;
        }
        throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
    }

    @Override
    public void importWith1688() {
        get2(0l);
    }




    public void get2(Long id) {
        CategoryGetParam param = new CategoryGetParam();
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        if (accessToken.getToken() != null) {
            param.setCategoryID(id);
            SDKResult<CategoryGetResult> execute = accessToken.getApiExecutor().execute(param, accessToken.getToken().getAccess_token());
            CategoryGetResult result = execute.getResult();
            try {
                CategoryCategoryInfo entity = result.getCategoryInfo()[0];
            }catch (Exception e){
                e.printStackTrace();
            }


        }else{
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }

    }


}
