package com.company.tem.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.HashSet;

/**
 * @Author: yuandh
 * @Description: session 监听
 * @Date: Created in 11:00 2019/4/3
 * @Modified By:
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info("--attributeAdded--");
        @SuppressWarnings("unused")
        HttpSession session = httpSessionBindingEvent.getSession();
        logger.info("key----:" + httpSessionBindingEvent.getName());
        logger.info("value---:" + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        logger.info("--attributeRemoved--");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        logger.info("--attributeReplaced--");
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("---sessionCreated----");
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        // 在application范围由一个HashSet集保存所有的session
        @SuppressWarnings("unchecked")
        HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
        if (sessions == null) {
            sessions = new HashSet<HttpSession>();
            application.setAttribute("sessions", sessions);
        }
        // 新创建的session均添加到HashSet集中
        sessions.add(session);
        // 可以在别处从application范围中取出sessions集合
        // 然后使用sessions.size()获取当前活动的session数，即为“在线人数”

        //添加新建的session到MySessionContext中;
        MySessionContext.AddSession(event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("---sessionDestroyed----");
        HttpSession session = event.getSession();
        logger.info("deletedSessionId: " + session.getId());
        System.out.println(session.getCreationTime());
        System.out.println(session.getLastAccessedTime());
        ServletContext application = session.getServletContext();
        HashSet<?> sessions = (HashSet<?>) application.getAttribute("sessions");
        // 销毁的session均从HashSet集中移除
        sessions.remove(session);

        //添加新建的session到MySessionContext中;
        MySessionContext.DelSession(session);
    }
}
