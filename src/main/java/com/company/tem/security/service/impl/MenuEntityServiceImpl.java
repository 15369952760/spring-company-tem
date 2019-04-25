package com.company.tem.security.service.impl;

import com.company.tem.security.entity.MenuEntity;
import com.company.tem.security.mapper.MenuEntityMapper;
import com.company.tem.security.service.MenuEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 16:40 2019/4/3
 * @Modified By:
 */
@Service
public class MenuEntityServiceImpl implements MenuEntityService {

    @Autowired
    MenuEntityMapper menuEntityMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MenuEntity record) {
        return menuEntityMapper.insert(record);
    }

    @Override
    public int insertSelective(MenuEntity record) {
        return menuEntityMapper.insertSelective(record);
    }

    @Override
    public MenuEntity selectByPrimaryKey(String id) {
        return menuEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MenuEntity record) {
        return menuEntityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MenuEntity record) {
        return menuEntityMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MenuEntity> selectAll() {
        return menuEntityMapper.selectBySelective(new MenuEntity());
    }

    @Override
    public List<MenuEntity> selectBySelective(MenuEntity record) {
        return menuEntityMapper.selectBySelective(record);
    }
}
