package com.system.service.impl;

import com.system.dao.RoleMenuDao;
import com.system.dao.UserRoleDao;
import com.system.domain.RoleDO;
import com.system.dao.RoleDao;
import com.system.domain.RoleMenuDO;
import com.system.domain.UserRoleDO;
import com.system.service.RoleService;
import com.common.shiro.ShiroTool;
import com.common.tool.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;



@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public RoleDO get(String id){
		return roleDao.get(id);
	}
	
	@Override
	public List<RoleDO> list(Map<String, Object> map){
		return roleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleDao.count(map);
	}
	
	@Override
	@Transactional
	public int save(RoleDO role){
		role.setId(MyUtils.getUUID32());
		role.setCreateDate(new Date());
		role.setCreateUser(ShiroTool.getUserId());
		role.setIsDelete(0);
		List<String> menuIds = role.getMenuIds();
		if(roleDao.save(role)>0){
			menuIds.forEach(e->{
				RoleMenuDO roleMenuDO = new RoleMenuDO();
				roleMenuDO.setId(MyUtils.getUUID32());
				roleMenuDO.setMenuId(e);
				roleMenuDO.setRoleId(role.getId());
				roleMenuDao.save(roleMenuDO);
			});
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override
	public int update(RoleDO role){
		/*return roleDao.update(role);*/
		List<String> menuIds = role.getMenuIds();
		roleMenuDao.removeByRoleId(role.getId());
		if(roleDao.update(role)>0){
			menuIds.forEach(e->{
				RoleMenuDO roleMenuDO = new RoleMenuDO();
				roleMenuDO.setId(MyUtils.getUUID32());
				roleMenuDO.setMenuId(e);
				roleMenuDO.setRoleId(role.getId());
				roleMenuDao.save(roleMenuDO);
			});
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override
	public int remove(String id){
		return roleDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return roleDao.batchRemove(ids);
	}

	@Override
	public List<UserRoleDO> getByUserId(String userId) {
		return userRoleDao.getByUserId(userId);
	}

	@Override
	public int removeByUserId(String userId) {
		return userRoleDao.removeByUserId(userId);
	}
}
