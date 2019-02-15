package com.system.dao;

import com.system.domain.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-05 22:47:27
 */
@Mapper
public interface UserRoleDao {

	UserRoleDO get(String id);
	
	List<UserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserRoleDO userRole);
	
	int update(UserRoleDO userRole);
	
	int remove(String id);

	int removeByUserId(String userId);
	
	int batchRemove(String[] ids);

	List<UserRoleDO> getByUserId(String userId);
}
