package com.leo.fly.ailibaba.common;

/**
 * 生成单例AccessToken
 *
 * @author xingkai.fan
 * @create 2018 04 25
 */
public class SingletonAccessToken {

    private volatile static AccessToken accessToken;
    private volatile static AccessToken orderAccessToken;

    public static AccessToken getAccessToken(){
        if(accessToken==null){
            synchronized (AccessToken.class){
                if (accessToken==null){
                    accessToken = new AccessToken();
                }
            }
        }
        return accessToken;
    }
    public static AccessToken getOrderAccessToken(){
        if(orderAccessToken==null){
            synchronized (AccessToken.class){
                if (orderAccessToken==null){
                    orderAccessToken = new AccessToken();
                }
            }
        }
        return orderAccessToken;
    }
}