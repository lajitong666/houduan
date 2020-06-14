package com.example.plus.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author cst
 * @since 2020-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户open_id
     */
    private String openId;

    /**
     * 昵称
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 真实姓名
     */
    private String signature;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户信誉值
     */
    private String credit;

    /**
     * 用户类别 0 普通用户 1 工作用户
     */
    private String type;

    /**
     * 预约的工作人员ID
     */
    private String appointment;

    /**
     * 被服务人员ID
     */
    private String served;

    /**
     * 总收益
     */
    private String earnings;

    /**
     * 已扔次数
     */
    private String count1;

    /**
     * 回收次数
     */
    private String count2;

    /**
     * 用户积分
     */
    private String integral;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户等级
     */
    private String grade;

    /**
     * 用户晒单图片路径
     */
    private String photo;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 登陆凭证
     */
    private String token;


}
