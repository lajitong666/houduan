package com.example.plus.mapper;

import com.example.plus.entity.VO.TrashVO;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户垃圾与收益表 Mapper 接口
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
public interface TrashDao {
    /**
     * 获取用户垃圾与收益
     * @param param
     * @return
     */
    List<TrashVO> get(HashMap<String, Object> param);
}
