package com.company.tem.security.mapper;

import com.company.tem.security.entity.MenuEntity;
import com.company.tem.security.entity.RoleEntity;
import com.company.tem.security.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserEntityMapper {

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
     * 查询
     * @param record
     * @return
     */
    List<UserEntity> selectEntityByData(UserEntity record);


    /**
     * 通过用户id查询当前用户的所有角色
     * @param id
     * @return
     */
    List<RoleEntity> selectRoleListByUserId(String id);

    /**
     * 通过对象数据查询
     * @param record
     * @return
     */
    List<UserEntity> selectSelective(UserEntity record);

    /**
     * 通过用户Id查询当前用户的所有菜单
     * @return
     */
    List<MenuEntity> selectMenuListByUserId(String id);
}
