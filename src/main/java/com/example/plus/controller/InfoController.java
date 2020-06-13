package com.example.plus.controller;

import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.VO.InfoVO;
import com.example.plus.entity.VO.DetailVO;
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
 * 资讯获取 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    com.example.plus.service.InfoService InfoService;

    @PostMapping("/getAll")
    public ApiResponse getIntegral() {
        List<InfoVO> infoVOS;
        try {
            infoVOS = InfoService.getAll();
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取资讯信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取资讯信息失败");
        }
        return ApiResponse.success(infoVOS);
    }
    @PostMapping("/getOne")
    public ApiResponse getOne(
            @RequestParam(value = "id") String id
    ) {
        List<DetailVO> detailVOS;
        try {
            detailVOS = InfoService.getOne(id);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取资讯信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取资讯信息失败");
        }
        return ApiResponse.success(detailVOS);
    }
}
