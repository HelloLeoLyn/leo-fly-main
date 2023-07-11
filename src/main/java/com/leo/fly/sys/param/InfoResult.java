package com.leo.fly.sys.param;

import lombok.Data;

import java.util.List;

@Data
public class InfoResult {
    private List<String> roles;
    private List<Long> roleIdList;
    private String introduction;
    private String avatar;
    private String name;
    private Long id;
    private String nick;
    private String phone;
    private Double amount;
    private Integer inviteId;
    private String thirdPartId;
    private String thirdPartName;
}
