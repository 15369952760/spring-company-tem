package com.company.tem.security.controller;

import com.company.common.RtnConstants;
import com.company.common.RtnData;
import com.company.common.util.StringUtil;
import com.company.tem.security.entity.MenuEntity;
import com.company.tem.security.service.MenuEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author: yuandh
 * @Description: 菜单管理
 * @Date: Created in 17:21 2019/4/3
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    MenuEntityService menuEntityService;

    /**
     * 添加菜单
     * @param menuEntity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public RtnData add(MenuEntity menuEntity){
        try{
            //设置当前时间与主键编号
            Date date = new Date();
            menuEntity.setId(StringUtil.getUUID());
            menuEntity.setCreateTime(date);
            menuEntity.setUpdateTime(date);
            menuEntityService.insert(menuEntity);
            return RtnData.ok(RtnConstants.RTN_INSERT_SUCCESS);
        } catch (Exception e){
            return RtnData.fail(RtnConstants.RTN_INSERT_ERROR);
        }
    }

    /**
     * 编辑
     * @param menuEntity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit")
    public RtnData update(MenuEntity menuEntity){
        try{
            //设置编辑时间
            menuEntity.setUpdateTime(new Date());
            menuEntityService.updateByPrimaryKey(menuEntity);
        return RtnData.ok(RtnConstants.RTN_UPDATE_SUCCESS);
    }catch (Exception e){
        return RtnData.fail(RtnConstants.RTN_UPDATE_ERROR);
    }
    }

    /**
     * 菜单集合
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public RtnData list(){
        return RtnData.ok(menuEntityService.selectAll());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del")
    public RtnData del(String id){
        try{
            menuEntityService.deleteByPrimaryKey(id);
        }catch (Exception e){
            return RtnData.fail(RtnConstants.RTN_DELETE_ERROR);
        }
        return RtnData.ok(RtnConstants.RTN_DELETE_SUCCESS);
    }



}
