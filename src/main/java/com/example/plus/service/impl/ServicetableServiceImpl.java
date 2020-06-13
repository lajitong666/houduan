package com.example.plus.service.impl;

import com.example.plus.entity.Servicetable;
import com.example.plus.mapper.ServicetableDao;
import com.example.plus.service.ServicetableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <p>
 * 服务表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-04-11
 */
@Service
public class ServicetableServiceImpl extends ServiceImpl<ServicetableDao, Servicetable> implements ServicetableService {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(ServicetableServiceImpl.class);

    @Resource
    ServicetableDao servicetableDao;

    @Override
    public void addOne(String served, String phone, String date, String serve, String address) {
        Servicetable servicetable = new Servicetable();
        String id ="ad-"+ UUID.randomUUID();
        servicetable.setServed(served);
        servicetable.setServe(serve);
        servicetable.setPhone(phone);
        servicetable.setDate(date);
        servicetable.setAddress(address);
        servicetable.setAutoId(id);

        try{
            servicetableDao.insert(servicetable);
        } catch (Exception e){
            logger.error(e.getMessage()+"数据库操作失败");
        }
    }
}
