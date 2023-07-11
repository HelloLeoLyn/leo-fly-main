package com.leo.fly.sys.param;


import com.leo.fly.web.param.BaseParam;
import com.leo.fly.sys.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserQueryParam extends BaseParam<SysUser> {
    private String name;
    private String mobile;
    private Integer inviteId;
    private String platform;
    private String deviceId;
    private String type;
    private String id;
    private String parentId;
}
