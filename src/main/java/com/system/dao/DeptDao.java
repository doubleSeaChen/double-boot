package com.system.dao;

import java.util.List;
import java.util.Map;

import com.system.domain.DeptDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:09:56
 */
@Mapper
public interface DeptDao {

	DeptDO get(String id);
	
	List<DeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
