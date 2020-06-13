package com.example.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.plus.common.utils.FileUtil;
import com.example.plus.controller.WasteController;
import com.example.plus.entity.Waste;
import com.example.plus.mapper.WasteDao;
import com.example.plus.service.WasteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 垃圾表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
@Service
public class WasteServiceImpl extends ServiceImpl<WasteDao, Waste> implements WasteService {

    @Resource
    WasteDao wasteDao;

    @Resource
    FileUtil fileUtil;

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(WasteServiceImpl.class);

    /**
     * 根据垃圾种类获取垃圾列表
     * @param type
     * @return
     */
    @Override
    public List<Waste> getAll(String type) {
        Waste waste = new Waste();
        waste.setType(type);

        QueryWrapper<Waste> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(waste);
        List<Waste> wasteList = null;
        try{
            wasteList = wasteDao.selectList(queryWrapper);

        } catch (Exception e){

        }
        return wasteList;
    }

    @Override
    public void addWaste(String name, String type, String detail, String price, MultipartFile photo, MultipartFile photoDetail) {
        Waste waste = new Waste();
        waste.setName(name);
        waste.setType(type);
        waste.setDetail(detail);
        waste.setPrice(price);

        String photoUrl =  fileUtil.storeFile(name,photo);
        String photoDetailUrl =  fileUtil.storeFile(name,photoDetail);
        waste.setPhoto(photoUrl);
        waste.setPhotoDetail(photoDetailUrl);

        try {
            wasteDao.insert(waste);
        } catch (Exception e) {
            logger.error("添加垃圾信息失败",e);
        }

    }

    @Override
    public Waste getWaste(String name) {
        QueryWrapper<Waste> queryWrapper = new QueryWrapper<>();
        Waste waste = new Waste();
        queryWrapper.setEntity(waste);
        waste.setName(name);
        try{
            waste = wasteDao.selectOne(queryWrapper);
        }catch (Exception e) {
            logger.error("获取垃圾详情信息时，数据库操作出错");
        }
        return waste;
    }
}
