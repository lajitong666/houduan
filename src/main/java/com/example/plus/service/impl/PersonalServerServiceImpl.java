package com.example.plus.service.impl;

import com.example.plus.entity.VO.PersonalServerVO;
import com.example.plus.mapper.PersonalServerDao;
import com.example.plus.service.PersonalServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 私人物业服务人员 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
@Service
public class PersonalServerServiceImpl implements PersonalServerService {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(PersonalServerServiceImpl.class);

    @Resource
    PersonalServerDao personalServerDao;

    @Override
    public List<PersonalServerVO> getAll() {
        List<PersonalServerVO> personalServers = null;
        try{
            personalServers = personalServerDao.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return personalServers;
    }
}
