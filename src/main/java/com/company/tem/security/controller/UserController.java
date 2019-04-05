package com.company.tem.security.controller;

import com.company.common.RtnData;
import com.company.common.util.StringUtil;
import com.company.tem.security.entity.UserEntity;
import com.company.tem.security.service.UserEntityService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 17:46 2019/4/2
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserEntityService userEntityService;


    /**
     * 新增一个用户数据
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public RtnData submitUser(UserEntity userEntity){
        if(StringUtil.isEmpty(userEntity.getId())){
            userEntity.setId(StringUtil.getUUID()); // 设置 主键
            userEntity.setPassword(StringUtil.md5(userEntity.getPassword())); // 加密密码
            userEntityService.insert(userEntity);
            return RtnData.ok("新建成功");
        } else {
            userEntityService.updateByPrimaryKeySelective(userEntity);
            return RtnData.ok("编辑成功");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    public RtnData userList(){
        return RtnData.ok(userEntityService.selectAll());
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RtnData delete(String userId){
        if(StringUtil.isNotEmpty(userId)){
            userEntityService.deleteByPrimaryKey(userId);
            return RtnData.ok("删除成功");
        } else {
            return RtnData.fail("用户Id为空");
        }
    }

}
