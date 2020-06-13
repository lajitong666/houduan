package com.example.plus.controller;


import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.User;
import com.example.plus.service.impl.ServicetableServiceImpl;
import com.example.plus.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务表 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/servicetable")
public class ServicetableController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(ServicetableController.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ServicetableServiceImpl servicetableService;

    @PostMapping(value = "/addOne")
    public ApiResponse addOne(
            @RequestParam(value = "served") String served,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "serve") String serve,
            @RequestParam(value = "address") String address
    ){
        try{
            servicetableService.addOne(served,phone,date,serve,address);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("增加服务信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("增加服务信息失败");
        }
        return ApiResponse.success();
    }

    @PostMapping(value = "/getAllService")//获取工作人员列表
    public ApiResponse getAllService(){
        List<User> userList ;
        try{
            userList = userService.getAllService();
        }catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取工作人员列表失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取工作人员列表失败");
        }
        return ApiResponse.success(userList);
    }

}
