package com.company.tem.security.controller;

import com.company.common.Constants;
import com.company.common.RtnData;
import com.company.common.ServletUtil;
import com.company.common.util.StringUtil;
import com.company.tem.aop.MySessionContext;
import com.company.tem.security.entity.UserEntity;
import com.company.tem.security.service.RoleEntityService;
import com.company.tem.security.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: yuandh
 * @Description: 安全模块
 * @Date: Created in 9:54 2019/4/3
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/security")
public class SecurityController {

    @Autowired
    UserEntityService userEntityService;


    /**
     * 登录功能
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RtnData login(@RequestParam(required = true) String username,
                         @RequestParam(required = true) String password ){
        try{
            List<UserEntity> userEntity = userEntityService.selectUserInfoByUserNamePwd(new UserEntity(username, StringUtil.md5(password)));
            //判断是否存在当前用户
            if(userEntity == null || userEntity.size() == 0){
                return RtnData.fail("账号密码错误");
            }
            if(userEntity.size() > 1){
                return RtnData.fail("用户名:" + username + "存在且多余1个");
            }
            // 获取当前request
            HttpServletRequest request = ServletUtil.getRequest();
            //获取session
            HttpSession session = request.getSession();
            HttpSession sessionVessel = MySessionContext.getSession(session.getId());
            if(StringUtil.isNotEmpty(sessionVessel)){
                MySessionContext.DelSession(sessionVessel);
            }
            session.setAttribute(Constants.SESSION_USER_ID, userEntity.get(0).getId());
            session.setAttribute(Constants.SESSION_USER, userEntity.get(0));
            session.setAttribute(Constants.SESSION_USER_USERNAME, userEntity.get(0).getUsername());
            MySessionContext.AddSession(session);
        }catch (Exception e) {
            return RtnData.fail("系统错误");
        }
        return RtnData.ok("登录成功");
    }


    /**
     * 注册
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RtnData register(UserEntity userEntity){
        if(StringUtil.isEmpty(userEntity)
                || StringUtil.isEmpty(userEntity.getUsername())
                || StringUtil.isEmpty(userEntity.getPassword())){
            return RtnData.fail("用户名与密码必须不为空");
        }
        UserEntity entity = new UserEntity();
        entity.setUsername(userEntity.getUsername());
        List<UserEntity> userEntities = userEntityService.selectEntityByData(entity);
        if(userEntities != null &&  userEntities.size() > 0){
            return RtnData.fail("注册失败：存在当前用户名");
        }
        //设置ID
        userEntity.setId(StringUtil.getUUID());
        userEntity.setPassword(StringUtil.md5(userEntity.getPassword()));
        //执行注册
        if(userEntityService.insert(userEntity) > 0){
            //注册成功
            // 获取当前request
            HttpServletRequest request = ServletUtil.getRequest();
            HttpSession session = request.getSession();
            HttpSession sessionVessel = MySessionContext.getSession(session.getId());
            if(StringUtil.isNotEmpty(sessionVessel)){
                MySessionContext.DelSession(sessionVessel);
            }
            session.setAttribute(Constants.SESSION_USER_ID, userEntity.getId());
            session.setAttribute(Constants.SESSION_USER, userEntity);
            session.setAttribute(Constants.SESSION_USER_USERNAME, userEntity.getUsername());
            MySessionContext.AddSession(session);
            return RtnData.ok("注册成功");
        }
        return RtnData.fail("注册失败");
    }


}
