package com.leo.fly.sys.param;

import lombok.Data;

@Data
public class SysLoginParam {
    private String time;
    private String token;
    private String targetSign;
    private String system;
    private String platform;
    private String username;
    private String password;
}
