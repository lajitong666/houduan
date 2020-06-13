package com.example.plus.mapper;

import com.example.plus.entity.VO.FindDetailVO;
import com.example.plus.entity.VO.FindVO;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 发现表 Mapper 接口
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
public interface FindDao {
    /**
     * 获取所有发现内容
     * @return
     */
    List<FindVO> getAll();

    /**
     * 获取发现的详情信息
     * @param param
     * @return
     */
    List<FindDetailVO> getOne(HashMap<String, Object> param);

    /**
     * 用户上传动态
     * @param param
     */
    void upload(HashMap<String, Object> param);
}
