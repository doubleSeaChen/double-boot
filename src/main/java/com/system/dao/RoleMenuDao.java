package com.system.dao;

import com.system.domain.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-05 22:47:27
 */
@Mapper
public interface RoleMenuDao {

	RoleMenuDO get(String id);

	List<RoleMenuDO> getByRoleId(String roleId);
	
	List<RoleMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(String id);

	int removeByRoleId(String roleId);
	
	int batchRemove(String[] ids);
}
