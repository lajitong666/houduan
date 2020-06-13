package com.example.plus.service;

import com.example.plus.entity.Servicetable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-04-11
 */
public interface ServicetableService extends IService<Servicetable> {

    void addOne(String served, String phone, String date, String serve, String address);
}
