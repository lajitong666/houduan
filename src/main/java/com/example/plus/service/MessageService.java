package com.example.plus.service;

import com.example.plus.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资讯表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-04-03
 */
public interface MessageService extends IService<Message> {

    List<Message> getAll();

    Message getMessage(String autoId);

    void addOne(String autoId, String photo, String photoDetail, String detail, String synopsis);
}
