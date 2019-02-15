package com.system.controller;

import com.common.annotation.Log;
import com.common.tool.MyUtils;
import com.system.domain.UserDO;
import com.system.service.UserService;
import com.common.shiro.ShiroTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @return
     */
    @Log("用户登录")
    @PostMapping("/login")
    @ResponseBody
    Object systemLogin(@RequestBody UserDO userDO){
        String pwd = MyUtils.EncoderByMd5(userDO.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(userDO.getUserName(), pwd);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            // 获取用户ID
            UserDO user = userService.getByUserName(userDO.getUserName());
            return user;
        }catch (AuthenticationException e){
            return 0;
        }
    }

    /**
     * 用户登出
     * @return
     */
    @Log("用户登出")
    @GetMapping("/sysLogout")
    @ResponseBody
    Object logout(){
        ShiroTool.logout();
        return 0;
    }

}
