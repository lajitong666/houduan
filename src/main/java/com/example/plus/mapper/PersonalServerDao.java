package com.example.plus.mapper;

import com.example.plus.entity.VO.PersonalServerVO;

import java.util.List;

/**
 * <p>
 * 私人物业服务人员 Mapper 接口
 * </p>
 *
 * @author cst
 * @since 2020-06-14
 */
public interface PersonalServerDao {
    /**
     * 获取物业服务人员信息
     * @return
     */
    List<PersonalServerVO> getAll();
}
