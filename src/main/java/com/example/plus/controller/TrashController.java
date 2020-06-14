package com.example.plus.controller;

import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.VO.TrashVO;
import com.example.plus.service.TrashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 晒单表 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/trash")
public class TrashController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(TrashController.class);

    @Autowired
    TrashService trashService;

    @PostMapping("/get")
    public ApiResponse get(
            @RequestParam("id") String id
    ){
        List<TrashVO> trashVOS;
        try {
            trashVOS = trashService.get(id);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取垃圾与收益信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取垃圾与收益信息失败");
        }
        return ApiResponse.success(trashVOS);
    }
}
