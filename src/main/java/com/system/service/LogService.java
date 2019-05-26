package com.system.service;


import com.system.domain.LogDO;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * 
 * @author doublesea
 * @date 2018-11-18 13:10:19
 */
public interface LogService {
	
	LogDO get(String id);
	
	List<LogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LogDO log);
	
	int update(LogDO log);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
