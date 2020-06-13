package com.example.plus.entity.VO;

import lombok.Data;

@Data
public class DetailVO {
    private String image; //资讯图片
    private String author; //作者
    private String uploadTime; //上传时间
    private String detail; //具体内容
}
