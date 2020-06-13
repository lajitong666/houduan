package com.example.plus.service;

import com.example.plus.entity.VO.DetailVO;
import com.example.plus.entity.VO.InfoVO;

import java.util.List;

/**
 * <p>
 * 资讯表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
public interface InfoService {
    /**
     * 获取资讯列表信息
     * @return
     */
    List<InfoVO> getAll();

    /**
     * 获取资讯详情信息
     * @param id
     * @return
     */
    List<DetailVO> getOne(String id);
}
