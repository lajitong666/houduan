package com.example.plus.service;

import com.example.plus.entity.VO.TrashVO;

import java.util.List;

/**
 * <p>
 * 垃圾与收益 服务类
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
public interface TrashService {
    /**
     * 获取用户的垃圾与收益
     * @param id
     * @return
     */
    List<TrashVO> get(String id);
}
