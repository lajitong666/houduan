package com.example.plus.service;

import com.example.plus.entity.VO.PersonalServerVO;

import java.util.List;

/**
 * <p>
 * 资讯表 服务类
 * </p>
 *
 * @author cst
 * @since 2020-04-03
 */
public interface PersonalServerService {
    /**
     * 获取私人物业管理服务人员信息列表
     * @return
     */
    List<PersonalServerVO> getAll();
}
