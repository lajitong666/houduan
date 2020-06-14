package com.example.plus.service.impl;

import com.example.plus.entity.VO.TrashVO;
import com.example.plus.mapper.TrashDao;
import com.example.plus.service.TrashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 资讯表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
@Service
public class TrashServiceImpl implements TrashService {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(TrashServiceImpl.class);

    @Resource
    TrashDao trashDao;

    @Override
    public List<TrashVO> get(String id) {
        List<TrashVO> trashVOS = null;
        try{
            HashMap<String,Object> param = new HashMap<>();
            param.put("id",id);
            trashVOS = trashDao.get(param);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return trashVOS;
    }
}
