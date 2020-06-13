package com.example.plus.service.impl;

import com.example.plus.entity.VO.DetailVO;
import com.example.plus.entity.VO.InfoVO;
import com.example.plus.entity.VO.IntegralVO;
import com.example.plus.mapper.InfoDao;
import com.example.plus.service.InfoService;
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
 * @since 2020-06-12
 */
@Service
public class InfoServiceImpl implements InfoService {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    @Resource
    InfoDao infoDao;

    @Override
    public List<InfoVO> getAll() {
        List<InfoVO> infoVOS = null;
        try{
            infoVOS = infoDao.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return infoVOS;
    }

    @Override
    public List<DetailVO> getOne(String id) {
        List<DetailVO> detailVOS = null;
        try{
            HashMap<String,Object> param = new HashMap<>();
            param.put("id",id);
            detailVOS = infoDao.getOne(param);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return detailVOS;
    }
}
