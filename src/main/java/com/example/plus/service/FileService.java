package com.example.plus.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件 服务类
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
public interface FileService {
    /**
     * 上传文件
     * @param multipartFile
     */
    void fileUpload(MultipartFile multipartFile,String fileName);
}
