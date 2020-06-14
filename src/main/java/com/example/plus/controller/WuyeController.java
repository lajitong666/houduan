package com.example.plus.controller;


import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.VO.FindVO;
import com.example.plus.entity.Wuye;
import com.example.plus.service.impl.WuyeServiceImpl;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
@RestController
@RequestMapping("/wuye")
public class WuyeController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(WuyeController.class);

    @Autowired
    WuyeServiceImpl wuyeService;

    @PostMapping("/getAll")
    public ApiResponse getAll() {
        Wuye wuye = new Wuye();
        try {
            wuye = wuyeService.getAll();
        } catch (BizException e){

            return ApiResponse.error("获取发现信息失败");
        } catch (Exception e) {

            return ApiResponse.error("获取发现信息失败");
        }
        return ApiResponse.success(wuye);
    }

}
