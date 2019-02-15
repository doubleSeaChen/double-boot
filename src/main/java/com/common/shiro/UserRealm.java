package com.common.shiro;

import com.system.config.ApplicationContextRegister;
import com.system.dao.UserDao;
import com.system.domain.UserDO;
import com.system.service.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserRealm extends AuthorizingRealm{

    /**
     * 实现用户登录的认证逻辑，返回当前用户所拥有的权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("查询用户相关权限逻辑");
        String userId = ShiroTool.getUserId();
        MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
        // 查询当前用户所拥有的权限标识
        Set<String> perms = menuService.listSign(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 设置用户的权限字符
        info.setStringPermissions(perms);
        return info;
    }

    /**
     * 实现用户的授权逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("userName", username);
        String password = new String((char[]) authenticationToken.getCredentials());

        UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);
        // 查询用户信息
        UserDO user = userMapper.list(map).get(0);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;

    }
}
