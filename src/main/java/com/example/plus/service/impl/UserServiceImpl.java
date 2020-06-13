package com.example.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.plus.common.exception.BizException;
import com.example.plus.common.utils.FileUtil;
import com.example.plus.entity.User;
import com.example.plus.mapper.UserDao;
import com.example.plus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserDao userDao;

    @Resource
    FileUtil fileUtil;

    @Override
    public void addUser(String openId,
                        String loginName,
                        String name,
                        String signature,
                        String sex,
                        String phone,
                        String address,
                        String credit,
                        String type,
                        String appointment,
                        String served,
                        String earnings,
                        String count1,
                        String count2,
                        String integral,
                        MultipartFile photo) {
        User user = new User();
        user.setOpenId(openId);
        user.setLoginName(loginName);
        user.setName(name);
        user.setSignature(signature);
        user.setSex(sex);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCredit(credit);
        user.setType(type);
        user.setAppointment(appointment);
        user.setServed(served);
        user.setEarnings(earnings);
        user.setCount1(count1);
        user.setCount2(count2);
        user.setIntegral(integral);
        String photoUrl = fileUtil.storeFile(name,photo);
        user.setPhoto(photoUrl);
        try{
            userDao.insert(user);
        } catch (Exception e){
            logger.error("新增用户失败");
            throw new BizException("数据库操作出现了问题");
        }
    }

    @Override
    public User getUserDetails(String openId) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        User user = new User();
        user.setOpenId(openId);
        userQueryWrapper.setEntity(user);

        try {
            user = userDao.selectOne(userQueryWrapper);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException("数据库操作出现了问题");
        }
        return user;
    }

    @Override
    public List<User> getAllService() {
        List<User> userList;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        User user = new User();
        user.setType("1");
        userQueryWrapper.setEntity(user);
        try{
            userList = userDao.selectList(userQueryWrapper);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException("数据库操作出现了问题");
        }
        return userList;
    }
}
