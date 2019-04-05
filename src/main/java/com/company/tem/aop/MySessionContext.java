package com.company.tem.aop;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 11:13 2019/4/3
 * @Modified By:
 */
public class MySessionContext {

    private static HashMap<String, HttpSession> mymap = new HashMap<>();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }
    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }
    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
            return null;
        return mymap.get(session_id);
    }
}
