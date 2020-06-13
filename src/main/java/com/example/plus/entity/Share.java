package com.example.plus.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 晒单表
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Share implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 晒单id（自动生成）
     */
    private String autoId;

    /**
     * 晒单图片路径
     */
    private String photo;

    /**
     * 评价详情
     */
    private String detail;

    /**
     * 点赞数
     */
    private String praise;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;


}
