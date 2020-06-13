package com.example.plus.common.utils;

import com.example.plus.common.exception.FileException;
import com.example.plus.entity.VO.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zuozhiwei
 *
 * 在调用以下接口时候都需要在类中声明如下两条语句
 * @javax.annotation.Resource
 * FileUtil fileUtil;
 */
@Component
public class FileUtil {

    Logger logger = LoggerFactory.getLogger(FileUtil.class);
    @Value("${file.uploadPath}")
    String uploadPath;

    @Value("${file.domain}")
    String domain;

    /**
     * 文件在本地存储的地址
     */
    private Path fileStorageLocation = null;


    /**
     * 存储文件到系统
     * @param file 文件
     * @return 文件名
     */
    public String storeFile(String userId,MultipartFile file) {
        this.getLocation();
        // 完整文件名
        String originName = StringUtils.cleanPath(file.getOriginalFilename());
        // 文件名后缀，最后一个.后面的
        String ext = originName.substring(originName.lastIndexOf("."));
        // 文件名拼接
        String fileName = originName.substring(0,originName.lastIndexOf(".")) + "-" + System.currentTimeMillis() + ext;
        fileName = userId + fileName;
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    /**
     * 下载文件
     * @param fileName
     * @return
     */
    public org.springframework.core.io.Resource loadFileAsResource(String fileName) {
        this.getLocation();
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            org.springframework.core.io.Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileException("File not found " + fileName, ex);
        }
    }

    /**
     * 获取文件的url
     * url拼接文件名，可直接访问文件
     * @param fileName
     * @return
     */
    public String getFileUrl(String fileName) {
        return domain+"/"+fileName;
    }


    /**
     * 创建对象
     */
    private void getLocation (){
        System.out.println(uploadPath);
        this.fileStorageLocation = Paths.get(uploadPath).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    /**
     * 上传单个文件
     * @param file 文件
     * @return
     */
    public UploadFileResponse uploadFile(String userId,MultipartFile file) {
        String fileName = storeFile(userId ,file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/xiaofang/file/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse uploadFileResponse = new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        return uploadFileResponse;
    }

    /*
    *单个文件上传调用方法实例如下
    @ApiOperation(value = "上传单个文件",notes = "上传单个文件",tags = CommonConstant.ADMIN_API_TAG)
    @PostMapping(value = "/uploadFile")
    public UploadFileResponse uploadFile(
            @ApiParam(value = "文件") @RequestParam("file") MultipartFile file
    ){
        return fileUtil.uploadFile(file);
    }
    *
    */

    /**
     * 上传单个、多个文件【上传文件一概使用该方法】
     * @param files
     * @return

    public List<UploadFileResponse> uploadMultipleFiles(MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }
     */

    /*
    *多个文件上传示例如下
    @ApiOperation(value = "上传多个文件",notes = "上传多个文件",tags = CommonConstant.ADMIN_API_TAG)
    @PostMapping(value = "/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return  fileUtil.uploadMultipleFiles(files);
    }
    *
    */

    /**
     * 下载文件
     * @param fileName
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public ResponseEntity<Resource> downloadFile(String fileName, HttpServletRequest request) throws UnsupportedEncodingException {

        // Load file as Resource
        org.springframework.core.io.Resource resource = loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(resource.getFilename(), "utf-8") + "\"")
                .body(resource);
    }

    /*
    *下载文件示例如下
    @ApiOperation(value = "下载文件",notes = "下载文件",tags = CommonConstant.ADMIN_API_TAG)
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(
            @ApiParam(value = "文件名") @PathVariable String fileName, HttpServletRequest request
    ) throws UnsupportedEncodingException {
        ResponseEntity<Resource> resourceResponseEntity = fileUtil.downloadFile(fileName,request);
        return resourceResponseEntity;
    }
    *
    */
}
