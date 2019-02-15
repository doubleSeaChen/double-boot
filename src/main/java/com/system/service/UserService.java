package com.system.service;


import com.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:11:22
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
