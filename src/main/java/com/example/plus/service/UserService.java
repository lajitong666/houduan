package com.example.plus.service;

import com.example.plus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-03-29
 */
public interface UserService extends IService<User> {

    void addUser(String openId, String loginName, String name, String signature, String sex, String phone, String address, String credit, String type, String appointment, String served, String earnings, String count1, String count2, String integral, String email,String grade,MultipartFile photo);

    User getUserDetails(String openId);

    List<User> getAllService();
}
