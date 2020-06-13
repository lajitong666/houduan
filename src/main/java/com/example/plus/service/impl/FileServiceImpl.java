package com.example.plus.service.impl;

import com.example.plus.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * <p>
 * 资讯表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public void fileUpload(MultipartFile multipartFile,String fileName) {
        try {
            String filePath = "C:\\Users\\Administrator\\Desktop\\images\\"+fileName;
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            outputStream.write(multipartFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
