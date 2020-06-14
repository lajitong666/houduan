package com.example.plus.controller;

import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.VO.PersonalServerVO;
import com.example.plus.service.PersonalServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 个人物业服务人员 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
@RestController
@RequestMapping("/personalServer")
public class PersonalServerController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(PersonalServerController.class);


    @Autowired
    PersonalServerService personalServiceService;

    @PostMapping(value = "/getAll")
    public ApiResponse getAll(

    ){
        List<PersonalServerVO> personalServers;
        try{
            personalServers = personalServiceService.getAll();
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取私人物业服务人员列表失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取私人物业服务人员列表失败");
        }
        return ApiResponse.success(personalServers);
    }
}
