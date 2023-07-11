package com.leo.fly.sys.param;

import com.leo.fly.sys.entity.SysRole;
import lombok.Data;

import java.util.List;

@Data
public class SysLoginResult {
    private List<SysRole> roles;
    private String token;
    private Long id;
    private String name;
}
