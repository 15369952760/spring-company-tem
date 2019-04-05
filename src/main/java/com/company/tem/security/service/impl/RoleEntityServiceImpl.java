package com.company.tem.security.service.impl;

import com.company.tem.security.entity.RoleEntity;
import com.company.tem.security.mapper.RoleEntityMapper;
import com.company.tem.security.service.RoleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 16:35 2019/4/3
 * @Modified By:
 */
@Service
public class RoleEntityServiceImpl implements RoleEntityService {

    @Autowired
    RoleEntityMapper roleEntityMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleEntity record) {
        return roleEntityMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleEntity record) {
        return roleEntityMapper.insertSelective(record);
    }

    @Override
    public RoleEntity selectByPrimaryKey(String id) {
        return roleEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleEntity record) {
        return roleEntityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleEntity record) {
        return roleEntityMapper.updateByPrimaryKey(record);
    }
}
