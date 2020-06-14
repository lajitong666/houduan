package com.example.plus.service.impl;

import com.example.plus.common.utils.FileUtil;
import com.example.plus.entity.VO.FindDetailVO;
import com.example.plus.entity.VO.FindVO;
import com.example.plus.mapper.FindDao;
import com.example.plus.service.FindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
public class FindServiceImpl implements FindService {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    @Resource
    FileUtil fileUtil;

    @Resource
    FindDao findDao;

    @Override
    public List<FindVO> getAll() {
        List<FindVO> findVOS = null;
        try{
            findVOS = findDao.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return findVOS;
    }

    @Override
    public List<FindDetailVO> getOne(String id) {
        List<FindDetailVO> findDetailVOS = null;
        try{
            HashMap<String,Object> param = new HashMap<>();
            param.put("id",id);
            findDetailVOS = findDao.getOne(param);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return findDetailVOS;
    }

    @Override
    public void upload(String name, String userImage, MultipartFile contentImage, String title, String detail) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("name",name);
        param.put("userImage",userImage);
        String fileName = fileUtil.storeFile(title,contentImage);
        param.put("contentImage",fileName);
        param.put("title",title);
        param.put("detail",detail);
        try{
            findDao.upload(param);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
