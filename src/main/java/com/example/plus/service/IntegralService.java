package com.example.plus.service;

import com.example.plus.entity.Integral;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.plus.entity.VO.IntegralVO;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户积分历史表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-04-01
 */
public interface IntegralService extends IService<Integral> {

    List<IntegralVO> getIntegral(String openId);
}
