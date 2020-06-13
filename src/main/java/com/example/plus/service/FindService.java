package com.example.plus.service;

import com.example.plus.entity.VO.FindDetailVO;
import com.example.plus.entity.VO.FindVO;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 * 发现表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-06-12
 */
public interface FindService {
    /**
     * 发现信息
     * @return
     */
    List<FindVO> getAll();

    /**
     * 获取发信的详情
     * @param id
     * @return
     */
    List<FindDetailVO> getOne(String id);

    /**
     * 用户上传动态
     * @param name
     * @param userImage
     * @param contentImage
     * @param title
     * @param detail
     */
    void upload(String name, String userImage, MultipartFile contentImage, String title, String detail);
}
