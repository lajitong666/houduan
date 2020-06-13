package com.example.plus.controller;


import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.Message;
import com.example.plus.service.impl.MessageServiceImpl;
import org.hibernate.validator.constraints.SafeHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 资讯表 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MessageController.class);


    @Autowired
    MessageServiceImpl messageService;

    @PostMapping(value = "/getAll")
    public ApiResponse getAll(

    ){
        List<Message> messageList = null;
        try{
            messageList = messageService.getAll();
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取资讯列表失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取资讯列表失败");
        }
        return ApiResponse.success(messageList);
    }

    @PostMapping(value = "getOne")
    public ApiResponse getOne(
            @RequestParam(value = "autoId") String autoId
    ) {
        Message message = null;
        try{
            message = messageService.getMessage(autoId);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取资讯详情失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取资讯详情失败");
        }
        return ApiResponse.success(message);
    }

    @PostMapping(value = "addOne")
    public ApiResponse addOne(
        @RequestParam(value = "autoId") String autoId,
        @RequestParam(value = "photo") String photo,
        @RequestParam(value = "photoDetail") String photoDetail,
        @RequestParam(value = "detail") String detail,
        @RequestParam(value = "synopsis") String synopsis
    ){
        try{
            messageService.addOne(autoId,photo,photoDetail,detail,synopsis);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("添加资讯详情失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("添加资讯详情失败");
        }
        return ApiResponse.success("添加资讯信息成功");
    }
}
