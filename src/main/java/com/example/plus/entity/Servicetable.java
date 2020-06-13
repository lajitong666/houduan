package com.example.plus.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务表
 * </p>
 *
 * @author cst
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Servicetable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务号（自动生成）
     */
    private String autoId;

    /**
     * 被服务者id
     */
    private String served;

    /**
     * 服务者id
     */
    private String serve;

    /**
     * 垃圾总价格
     */
    private String earnings;

    /**
     * 垃圾详情（瓶子几个，箱子几个）
     */
    private String detail;

    /**
     * 服务评价等级
     */
    private String grade;

    /**
     * 用户评价详情
     */
    private String evaluationDetails;

    /**
     * 创建时间()
     */
    private LocalDateTime createDate;

    /**
     * 更新时间（）
     */
    private LocalDateTime updateDate;

    /**
     * 被服务的客户的电话
     */
    private String phone;

    /**
     * 客户约定服务时间
     */
    private String date;

    /**
     * 客户详细地址
     */
    private String address;


}
