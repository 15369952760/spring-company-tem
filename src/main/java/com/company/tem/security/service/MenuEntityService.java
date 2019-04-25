package com.company.tem.security.service;

import com.company.tem.security.entity.MenuEntity;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 16:39 2019/4/3
 * @Modified By:
 */
public interface MenuEntityService {

    int deleteByPrimaryKey(String id);

    int insert(MenuEntity record);

    int insertSelective(MenuEntity record);

    MenuEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuEntity record);

    int updateByPrimaryKey(MenuEntity record);

    List<MenuEntity> selectAll();

    List<MenuEntity> selectBySelective(MenuEntity record);

}
