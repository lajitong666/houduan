package com.example.plus.controller;


import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.User;
import com.example.plus.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Cache;

import java.sql.Wrapper;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-03-29
 */
@Api(value = "小程序用户端接口")
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userService;

    @ApiOperation(value = "小程序新增用户",tags = "所有信息添加")
    @PostMapping("/addUser")
    public ApiResponse addUser(
            @ApiParam(value = "小程序用户的open_id") @RequestParam(value = "openId")  String openId,
            @ApiParam(value = "小程序用户的微信昵称") @RequestParam(value = "loginName") String loginName,
            @ApiParam(value = "小程序用户的真实姓名")  @RequestParam(value = "name") String name,
            @ApiParam(value = "小程序用户的个人签名")  @RequestParam(value = "signature") String signature,
            @ApiParam(value = "小程序用户的性别")   @RequestParam(value = "sex") String sex,
            @ApiParam(value = "小程序用户的手机号")   @RequestParam(value = "phone") String phone,
            @ApiParam(value = "小程序用户的住址")   @RequestParam(value = "address") String address,
            @ApiParam(value = "小程序用户的信誉值")   @RequestParam(value = "credit") String credit,
            @ApiParam(value = "小程序用户的用户类型")   @RequestParam(value = "type") String type,
            @ApiParam(value = "小程序用户的预约的工作人员ID")    @RequestParam(value = "appointment") String appointment,
            @ApiParam(value = "小程序工作人员被预约的客户的ID")    @RequestParam(value = "served") String served,
            @ApiParam(value = "小程序用户的收益")   @RequestParam(value = "earnings") String earnings,
            @ApiParam(value = "小程序用户的垃圾分类的次数")     @RequestParam(value = "count1") String count1,
            @ApiParam(value = "小程序用户的垃圾回收的次数")    @RequestParam(value = "count2") String count2,
            @ApiParam(value = "小程序用户的总积分")    @RequestParam(value = "integral") String integral,
            @ApiParam(value = "小程序用户的晒单的图片路径")    @RequestParam(value = "photo") MultipartFile photo
    ){
        try {
            userService.addUser(openId,loginName,name,signature,sex,phone,address,credit,type,appointment,served,earnings,count1,count2,integral,photo);
        } catch (BizException e) {
            logger.error(e.getErrMessage());
            return ApiResponse.error("新增用户失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("新增用户失败");
        }
            return ApiResponse.success("新增用户成功");
    }

    @ApiOperation(value = "小程序获取用户信息",tags = "直接将用户所有信息获取")
    @PostMapping("/getUserDetails")
    public ApiResponse getOne(
            @ApiParam(value = "小程序用户的open_id") @RequestParam(value = "openId") String openId
    ){
        User user = null;
        try{
            user = userService.getUserDetails(openId);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取用户信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取用户信息失败");
        }
        return ApiResponse.success(user);
    }

}
