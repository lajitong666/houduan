package com.example.plus.entity.VO;

import lombok.Data;

@Data
public class FindVO {
    private String findId;//id
    private String name; //用户名
    private String userImage;//用户头像
    private String contentImage; //内容图片
    private String uploadTime; //上传时间
    private String title; //标题内容
}
