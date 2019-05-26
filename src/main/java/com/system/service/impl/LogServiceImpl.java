package com.system.service.impl;


import com.system.dao.LogDao;
import com.system.domain.LogDO;
import com.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;
	
	@Override
	public LogDO get(String id){
		return logDao.get(id);
	}
	
	@Override
	public List<LogDO> list(Map<String, Object> map){
		map.put("sort","create_date");
		map.put("order","desc");
		return logDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return logDao.count(map);
	}
	
	@Override
	public int save(LogDO log){
		return logDao.save(log);
	}
	
	@Override
	public int update(LogDO log){
		return logDao.update(log);
	}
	
	@Override
	public int remove(String id){
		return logDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return logDao.batchRemove(ids);
	}
	
}
