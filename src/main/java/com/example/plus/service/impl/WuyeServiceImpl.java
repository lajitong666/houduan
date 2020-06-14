package com.example.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.plus.entity.Wuye;
import com.example.plus.mapper.WuyeDao;
import com.example.plus.service.WuyeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
@Service
public class WuyeServiceImpl extends ServiceImpl<WuyeDao, Wuye> implements WuyeService {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(WuyeServiceImpl.class);

    @Resource
    WuyeDao wuyeDao;

    /**
     * 获取物业详情信息
     * @return
     */
    @Override
    public Wuye getAll() {
        Wuye wuye = new Wuye();
        QueryWrapper<Wuye> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(wuye);
        try{
            wuye = wuyeDao.selectOne(queryWrapper);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return wuye;
    }
}
