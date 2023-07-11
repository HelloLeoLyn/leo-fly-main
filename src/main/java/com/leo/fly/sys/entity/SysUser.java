package com.leo.fly.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_sys_user")
public class SysUser extends BasePo {

    /**
     * 编号
     */

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String name;
    /**
     * 昵称
     */
    private String nick;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

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
     * 平台
     */
    private String platform;

    @TableField(exist=false)
    private transient List<SysRole> roles;

    private String thirdPartId;

    private String thirdPartName;

    private String thirdPartPlatform;


}
