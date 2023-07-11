package com.leo.fly.sys.param;

import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.entity.SysUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class SysUserVo {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;



    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer delFlag;

    /**
     * 头像
     */
    private String headerUrl;

    /**
     * 签到日期
     */
    private String signDate;

    /**
     * 是否vip
     */
    private Boolean isVip;

    /**
     * vip过期时间
     */
    private LocalDateTime vipExpires;

    /**
     * 邀请码
     */
    private Integer inviteId;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属角色
     */
    private Collection<SysRole> roles;

    /**
     * 拥有菜单权限
     */
    private List<Integer> SysMenus;

    public SysUserVo(SysUser user){
        BeanUtils.copyProperties(user,this);
    }
    private Long expire;
}
