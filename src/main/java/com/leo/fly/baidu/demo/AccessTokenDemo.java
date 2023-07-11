package com.leo.fly.baidu.demo;

import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;

// 获取AccessToken 示例代码
public class AccessTokenDemo {
    public static void main(String[] args) {
        String path = "https://aip.baidubce.com/oauth/2.0/token";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.POST, path);


        // 设置header参数
        request.addHeaderParameter("Content-Type", "application/json;charset=UTF-8");

        // 设置query参数
        request.addQueryParameter("client_id", "Hjldy8KLOfcskcFELypXPIzm");
        request.addQueryParameter("client_secret", "syqdsFmDtWz96ZgHcPIYMZlt4XsBD7TT");
        request.addQueryParameter("grant_type", "client_credentials");


        ApiExplorerClient client = new ApiExplorerClient();

        try {
            ApiExplorerResponse response = client.sendRequest(request);
            // 返回结果格式为Json字符串
            System.out.println(response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}