package com.system.dao;

import java.util.List;
import java.util.Map;

import com.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author doublesea
 * @date 2018-11-18 13:11:22
 */
@Mapper
public interface UserDao {

	UserDO get(String id);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	UserDO getByUserName(String userName);
}
