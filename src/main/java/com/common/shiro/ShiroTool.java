package com.common.shiro;

import com.system.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroTool {

    @Autowired
    private static SessionDAO sessionDAO;

    /**
     * 返回Subject
     * @return
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    /**
     * 返回系统当前用户
     * @return
     */
    public static UserDO getUser(){
        Object object = getSubject().getPrincipal();
        return (UserDO)object;
    }

    /**
     * 返回当前用户Id
     * @return
     */
    public static String getUserId(){
        return getUser().getId();
    }

    /**
     * 用户登出
     */
    public static void logout(){
        getSubject().logout();
    }

}
