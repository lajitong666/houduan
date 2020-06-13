package com.example.plus.mapper;

import com.example.plus.entity.Integral;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.plus.entity.VO.IntegralVO;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户积分历史表 Mapper 接口
 * </p>
 *
 * @author cst
 * @since 2020-04-01
 */
public interface IntegralDao extends BaseMapper<Integral> {

    List<IntegralVO> getIntegral(HashMap<String, Object> param);
}
