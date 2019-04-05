package com.company.tem.security.service;

import com.company.tem.security.entity.UserEntity;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 17:43 2019/4/2
 * @Modified By:
 */
public interface UserEntityService {

    int deleteByPrimaryKey(String id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    /**
     * 全查询
     * @return
     */
    List<UserEntity> selectAll();

    /**
     * 通过对象数据查询
     * @param record
     * @return
     */
    List<UserEntity> selectSelective(UserEntity record);

    /**
     * 查询
     * @param record
     * @return
     */
    List<UserEntity> selectEntityByData(UserEntity record);

    /**
     * 通过用户名与密码查询当前用户的用户信息
     * 当前用户关联的所有角色信息
     * 当前永不关联的所有菜单信息
     * @param record
     * @return
     */
    List<UserEntity> selectUserInfoByUserNamePwd(UserEntity record);

}
