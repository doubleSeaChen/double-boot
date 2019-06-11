package com.system.service.impl;


import com.system.config.DoubleBootConfig;
import com.system.dao.UserDao;
import com.system.dao.UserRoleDao;
import com.system.domain.UserDO;
import com.system.domain.UserRoleDO;
import com.system.service.UserService;
import com.common.shiro.ShiroTool;
import com.common.tool.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private DoubleBootConfig doubleBootConfig;
	
	@Override
	public UserDO get(String id){
		return userDao.get(id);
	}
	
	@Override
	public List<UserDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	@Transactional
	public int save(UserDO user){
		user.setId(MyUtils.getUUID32());
		user.setCreateDate(new Date());
		user.setCreateUser(ShiroTool.getUserId());
		user.setPassword(MyUtils.EncoderByMd5(user.getPassword()));
		user.setHeadPath(doubleBootConfig.getUploadPath() + "user.png");
		List<String> roleIds = user.getRoleIds();
		if(userDao.save(user)>0){
			roleIds.forEach(e->{
				UserRoleDO userRoleDO = new UserRoleDO();
				userRoleDO.setId(MyUtils.getUUID32());
				userRoleDO.setUserId(user.getId());
				userRoleDO.setRoleId(e);
				userRoleDao.save(userRoleDO);
			});
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override
	@Transactional
	public int update(UserDO user){
		List<String> roleIds = user.getRoleIds();
		// 删除已关联的角色
		userRoleDao.removeByUserId(user.getId());

		if(userDao.update(user)>0){
			roleIds.forEach(e->{
				UserRoleDO userRoleDO = new UserRoleDO();
				userRoleDO.setId(MyUtils.getUUID32());
				userRoleDO.setUserId(user.getId());
				userRoleDO.setRoleId(e);
				userRoleDao.save(userRoleDO);
			});
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override
	public int remove(String id){
		return userDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return userDao.batchRemove(ids);
	}

	@Override
	public UserDO getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	@Override
	public int personUpdate(UserDO user) {
		if(userDao.update(user)>0){
			return 1;
		}else{
			return 0;
		}
	}
}
