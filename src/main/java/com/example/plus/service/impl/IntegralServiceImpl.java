package com.example.plus.service.impl;

import com.example.plus.entity.Integral;
import com.example.plus.entity.VO.IntegralVO;
import com.example.plus.mapper.IntegralDao;
import com.example.plus.service.IntegralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户积分历史表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-04-01
 */
@Service
public class IntegralServiceImpl extends ServiceImpl<IntegralDao, Integral> implements IntegralService {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(IntegralServiceImpl.class);

    @Resource
    IntegralDao integralDao;

    @Override
    public List<IntegralVO> getIntegral(String openId) {
        List<IntegralVO> integralVOList = null;
        try{
            HashMap<String,Object> param = new HashMap<>();
            param.put("openId",openId);
            integralVOList = integralDao.getIntegral(param);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return integralVOList;
    }
}
