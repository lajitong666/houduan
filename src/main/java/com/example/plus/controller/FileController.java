package com.example.plus.controller;

import com.example.plus.common.ApiResponse;
import com.example.plus.common.ErrorCodeEnum;
import com.example.plus.common.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件 前端控制器
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    com.example.plus.service.FileService fileService;

    @PostMapping("/fileUpload")  //上传图片
    public ApiResponse fileUpload(
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("fileName") String fileName
    ){
        try {
            fileService.fileUpload(multipartFile,fileName);
        }catch (BizException e){
            logger.error("添加图片失败",e);
            return ApiResponse.error(e.getErrMessage());
        }catch (Exception e){
            logger.error("添加图片失败",e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success("图片添加成功");
    }

}
