package com.leo.fly.ailibaba.access;

import com.alibaba.ocean.rawsdk.client.exception.OceanException;

/**
 * 权限处理
 * Created by Administrator on 2018/4/24.
 * @author xingkai.fan
 */

public interface AccessService {
    /**
     * 获取Access权限
     * @return
     */
    void getAccess(String code) throws OceanException;
//
//    /**
//     * 获取Access权限
//     * @return
//     */
    String auth();
}