package com.example.plus.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.plus.common.ApiResponse;
import com.example.plus.common.ErrorCodeEnum;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.Waste;
import com.example.plus.service.WasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 垃圾表 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/waste")
public class WasteController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(WasteController.class);

    @Autowired
    WasteService wasteService;

    /**
     * 获取垃圾信息（按种类）
     * @param type
     * @return
     */
    @PostMapping(value = "getAll")
    public ApiResponse getAll(
            @RequestParam(value = "type") String type  //垃圾种类
    ){
        List<Waste> wasteList = new ArrayList<>();
        try{
            wasteList = wasteService.getAll(type);
        } catch (BizException e) {
            logger.error("获取垃圾信息失败",e);
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取垃圾信息失败",e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(wasteList);
    }

    /**
     * 根据垃圾名称获取垃圾详情信息
     * @param name 垃圾名称
     * @return
     */
    @PostMapping(value = "getOne")
    public ApiResponse getOne(
            @RequestParam(value = "name") String name
    ){
        Waste waste = null;
        try{
            waste = wasteService.getWaste(name);
        } catch (BizException e) {
            logger.error("获取垃圾详细信息失败",e);
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取垃圾详细信息失败",e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(waste);
    }

    /**
     * 增加垃圾信息
     * @param name
     * @param type
     * @param detail
     * @param price
     * @param photo
     * @param photoDetail
     * @return
     */
    @PostMapping(value = "addWaste")
    public ApiResponse addWaste(
            @RequestParam(value = "name") String name, //垃圾名称
            @RequestParam(value = "type") String type, //垃圾种类
            @RequestParam(value = "detail") String detail, //垃圾详情
            @RequestParam(value = "price") String price, //垃圾行价
            @RequestParam(value = "photo") MultipartFile photo, //垃圾图片
            @RequestParam(value = "photoDetail") MultipartFile photoDetail //垃圾详情图
    ) {
        try {
            wasteService.addWaste(name,type,detail,price,photo,photoDetail);
        } catch (BizException e) {
            logger.error("添加垃圾信息失败",e);
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("添加垃圾信息失败",e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
         return ApiResponse.success("添加垃圾信息成功");
    }
}
