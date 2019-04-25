package com.company.tem.security.mapper;

import com.company.tem.security.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(MenuEntity record);

    int insertSelective(MenuEntity record);

    MenuEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuEntity record);

    int updateByPrimaryKey(MenuEntity record);

    List<MenuEntity> selectBySelective(MenuEntity record);
}
