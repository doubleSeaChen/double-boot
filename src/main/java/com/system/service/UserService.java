package com.system.service;


import com.common.tool.Tree;
import com.system.domain.DeptDO;
import com.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * @author doublesea
 */
public interface UserService {
	
	UserDO get(String id);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);

	int personUpdate(UserDO user);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	UserDO getByUserName(String userName);
}
