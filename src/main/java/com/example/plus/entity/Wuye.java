package com.example.plus.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Wuye implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物业名称
     */
    private String name;

    /**
     * 物业简介
     */
    private String synopsis;

    /**
     * 物业评分
     */
    private String grade;

    /**
     * 物业图标
     */
    private String image;

    /**
     * 物业所属地区
     */
    private String address;

    /**
     * 物业具体内容（待定）
     */
    private String detail;


}
