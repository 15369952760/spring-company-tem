package com.company.tem.security.service.impl;

import com.company.tem.security.entity.UserEntity;
import com.company.tem.security.mapper.UserEntityMapper;
import com.company.tem.security.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 17:44 2019/4/2
 * @Modified By:
 */
@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    UserEntityMapper mapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserEntity record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(UserEntity record) {
        return mapper.insertSelective(record);
    }

    @Override
    public UserEntity selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserEntity record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserEntity record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserEntity> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<UserEntity> selectSelective(UserEntity record) {
        return mapper.selectSelective(record);
    }

    @Override
    public List<UserEntity> selectEntityByData(UserEntity record) {
        return mapper.selectEntityByData(record);
    }

    @Override
    public List<UserEntity> selectUserInfoByUserNamePwd(UserEntity record) {
        //通过账号密码查询用户
        List<UserEntity> userEntityList = mapper.selectEntityByData(record);
        if(userEntityList == null || userEntityList.size() == 0){  return null; }
        UserEntity userEntity = userEntityList.get(0);
        //设置角色信息
        userEntity.setRoleList(mapper.selectRoleListByUserId(userEntity.getId()));
        //设置菜单信息
        userEntity.setMenuList(mapper.selectMenuListByUserId(userEntity.getId()));
        return userEntityList;
    }
}
