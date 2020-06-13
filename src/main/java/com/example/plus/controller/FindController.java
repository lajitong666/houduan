package com.example.plus.controller;

import com.example.plus.common.ApiResponse;
import com.example.plus.common.exception.BizException;
import com.example.plus.entity.VO.FindDetailVO;
import com.example.plus.entity.VO.FindVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 发现 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/find")
public class FindController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(FindController.class);

    @Autowired
    com.example.plus.service.FindService findService;

    @PostMapping("/getAll")
    public ApiResponse getAll() {
        List<FindVO> findVOS;
        try {
            findVOS = findService.getAll();
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取发现信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取发现信息失败");
        }
        return ApiResponse.success(findVOS);
    }
    @PostMapping("/getOne")
    public ApiResponse getOne(
            @RequestParam(value = "id") String id
    ) {
        List<FindDetailVO> findDetailVOS;
        try {
            findDetailVOS = findService.getOne(id);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取发现信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取发现信息失败");
        }
        return ApiResponse.success(findDetailVOS);
    }
    @PostMapping("/upload")
    public ApiResponse upload(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "userImage") String userImage,
            @RequestParam(value = "contentImage") MultipartFile contentImage,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "detail") String detail
    ) {
        try {
            findService.upload(name,userImage,contentImage,title,detail);
        } catch (BizException e){
            logger.error(e.getErrMessage());
            return ApiResponse.error("获取发现信息失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ApiResponse.error("获取发现信息失败");
        }
        return ApiResponse.success("上传成功");
    }
}
