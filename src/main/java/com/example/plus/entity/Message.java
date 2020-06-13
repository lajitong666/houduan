package com.example.plus.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资讯表
 * </p>
 *
 * @author cst
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资讯号（自动生成）
     */
    private String autoId;

    /**
     * 简图
     */
    private String photo;

    /**
     * 详情图片路径
     */
    private String photoDetail;

    /**
     * 详情
     */
    private String detail;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 资讯简介
     */
    private String synopsis;


}
