package com.leo.fly.ailibaba.order;

import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.web.form.BaseQueryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order1688ServiceImpl implements Order1688Service {



    @Override
    public AlibabaTradeGetSellerOrderListResult list(BaseQueryForm form) {
        AccessToken orderAccessToken = SingletonAccessToken.getOrderAccessToken();
        if (orderAccessToken.getToken() == null) {
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688_ORDER);
        }
        AlibabaTradeGetSellerOrderListParam request = new AlibabaTradeGetSellerOrderListParam();
        request.setPage((int)form.getCurrent());
        request.setPageSize((int)form.getSize());
        SDKResult<AlibabaTradeGetSellerOrderListResult> sdk = orderAccessToken.getApiExecutor().execute(request,orderAccessToken.getToken().getAccess_token());
        if(StringUtils.equals("gw.APIACLDecline",sdk.getErrorCode())){
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688_ORDER);
        }
        AlibabaTradeGetSellerOrderListResult result = sdk.getResult();
        return result;
    }
}
