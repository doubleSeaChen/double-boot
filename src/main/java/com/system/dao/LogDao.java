package com.system.dao;


import java.util.List;
import java.util.Map;

import com.system.domain.LogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:10:19
 */
@Mapper
public interface LogDao {

	LogDO get(String id);
	
	List<LogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LogDO log);
	
	int update(LogDO log);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
