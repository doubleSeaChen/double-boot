package com.system.dao;


import java.util.List;
import java.util.Map;

import com.system.domain.RoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:11:31
 */
@Mapper
public interface RoleDao {

	RoleDO get(String id);
	
	List<RoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
