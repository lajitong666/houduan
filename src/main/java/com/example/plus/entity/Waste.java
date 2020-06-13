package com.example.plus.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 垃圾表
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Waste implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 垃圾名称
     */
    private String name;

    /**
     * 垃圾类别
     */
    private String type;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 行价
     */
    private String price;

    /**
     * 垃圾图片路径
     */
    private String photo;

    /**
     * 垃圾详情图片路径
     */
    private String photoDetail;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;


}
