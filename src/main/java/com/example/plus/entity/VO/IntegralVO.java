package com.example.plus.entity.VO;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class IntegralVO {


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
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

}
