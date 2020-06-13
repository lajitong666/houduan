package com.example.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.plus.common.ApiResponse;
import com.example.plus.entity.Message;
import com.example.plus.mapper.MessageDao;
import com.example.plus.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 资讯表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-04-03
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Resource
    MessageDao messageDao;

    @Override
    public List<Message> getAll() {
        List<Message> messageList = null;
        Message message = new Message();
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(message);
        try{
            messageList = messageDao.selectList(queryWrapper);
        } catch (Exception e){
            logger.error(e.getMessage()+"数据库操作失败");
        }
        return messageList;
    }

    @Override
    public Message getMessage(String autoId) {
        Message message = new Message();
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        message.setAutoId(autoId);
        queryWrapper.setEntity(message);
        try{
            message = messageDao.selectOne(queryWrapper);
        } catch (Exception e){
            logger.error(e.getMessage()+"数据库操作失败");
        }
        return message;
    }

    @Override
    public void addOne(String autoId, String photo, String photoDetail, String detail, String synopsis) {
        Message message = new Message();
        message.setAutoId(autoId);
        message.setPhoto(photo);
        message.setPhotoDetail(photoDetail);
        message.setDetail(detail);
        message.setSynopsis(synopsis);

        try{
            messageDao.insert(message);
        } catch (Exception e) {
            logger.error(e.getMessage()+"数据操作失败");
        }
        return ;
    }
}
