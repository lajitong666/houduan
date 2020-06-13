package com.example.plus.mapper;

import com.example.plus.entity.VO.DetailVO;
import com.example.plus.entity.VO.InfoVO;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 资讯表 Mapper 接口
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
public interface InfoDao {
    /**
     * 获取资讯表
     * @return
     */
    List<InfoVO> getAll();

    /**
     * 获取一个资讯信息
     * @param param
     * @return
     */
    List<DetailVO> getOne(HashMap<String, Object> param);
}
