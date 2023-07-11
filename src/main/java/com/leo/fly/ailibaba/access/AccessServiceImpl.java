package com.leo.fly.ailibaba.access;

import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.entity.AuthorizationToken;
import com.leo.fly.ailibaba.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 获取Access_token
 *
 * @author xingkai.fan
 * @create 2018 04 24
 */
@Service
public class AccessServiceImpl implements AccessService  {
    @Value("${APPKEY}")
    private String appKey;

    @Value("${SECKEY}")
    private String secKey;

    @Value("${REDIRECT_URL}")
    private String REDIRECT_URL;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void getAccess(String code) {
        ApiExecutor apiExecutor = new ApiExecutor(appKey,secKey);
        AuthorizationToken token = apiExecutor.getToken(code);
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        accessToken.setAccessToken(token,apiExecutor);
        if (null!= SingletonTimer.getTokenTimer()){
            SingletonTimer.getTokenTimer().shutdown();
            SingletonTimer.setScheduledExecutorService(null);
            logger.info("线程池设为空...");
        }
        ScheduledExecutorService timer = SingletonTimer.getTokenTimer();
        logger.info("获取线程池对象："+timer);

        TokenTimer tokenTimer = new TokenTimer(accessToken);
        logger.info("运行指定定时线程");
        timer.scheduleAtFixedRate(tokenTimer,10L,10L,TimeUnit.HOURS);
    }

    @Override
    public String auth() {
        //对参数进行处理
        Base64.Encoder encoder = Base64.getEncoder();
        String encodeToString = encoder.encodeToString(REDIRECT_URL.getBytes());
        String requestUrl = AuthorizationRequest.verifyAuth(appKey, REDIRECT_URL,encodeToString);
        return requestUrl;
    }
}