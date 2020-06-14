package com.example.plus.service;

import com.example.plus.entity.Wuye;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
public interface WuyeService extends IService<Wuye> {

    Wuye getAll();
}
