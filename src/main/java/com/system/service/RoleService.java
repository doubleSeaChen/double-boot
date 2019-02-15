package com.system.service;


import com.system.domain.RoleDO;
import com.system.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:11:31
 */
public interface RoleService {
	
	RoleDO get(String id);
	
	List<RoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<UserRoleDO> getByUserId(String userId);

	int removeByUserId(String userId);
}
