package com.example.plus.service.impl;

import com.example.plus.entity.Share;
import com.example.plus.mapper.ShareDao;
import com.example.plus.service.ShareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 晒单表 服务实现类
 * </p>
 *
 * @author cst
 * @since 2020-03-28
 */
@Service
public class ShareServiceImpl extends ServiceImpl<ShareDao, Share> implements ShareService {

}
