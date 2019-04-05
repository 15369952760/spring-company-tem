package com.company.tem.security.service;

import com.company.tem.security.entity.RoleEntity;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 16:34 2019/4/3
 * @Modified By:
 */
public interface RoleEntityService {

    int deleteByPrimaryKey(String id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);

}
