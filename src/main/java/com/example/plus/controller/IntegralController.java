package com.example.plus.controller;


import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.VO.IntegralVO;
import com.example.plus.service.impl.IntegralServiceImpl;
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
 * 用户积分历史表 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-04-01
 */
@RestController
@RequestMapping("/integral")
public class IntegralController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(IntegralController.class);

    @Autowired
    IntegralServiceImpl integralService;

    @PostMapping("/getIntegral")
    public ApiResponse getIntegral(
        @RequestParam(value = "openId") String openId
    ) {
        List<IntegralVO> integralVOList = null;
        try {
            integralVOList = integralService.getIntegral(openId);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取用户信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取用户信息失败");
        }
        return ApiResponse.success(integralVOList);
    }
}
