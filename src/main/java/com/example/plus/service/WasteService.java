package com.example.plus.service;

import com.example.plus.entity.Waste;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 垃圾表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
public interface WasteService extends IService<Waste> {

    List<Waste> getAll(String type);

    void addWaste(String name, String type, String detail, String price, MultipartFile photo, MultipartFile photoDetail);

    Waste getWaste(String name);
}
