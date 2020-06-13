package com.example.plus.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户积分历史表
 * </p>
 *
 * @author cst
 * @since 2020-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Integral implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户open_id
     */
    private String openId;

    /**
     * 积分获取详情   用逗号隔开
     */
    private String details;

    /**
     * 获得的总积分
     */
    private String integral;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;


}
