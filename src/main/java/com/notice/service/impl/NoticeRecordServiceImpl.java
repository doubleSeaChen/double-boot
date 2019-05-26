package com.notice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.notice.dao.NoticeRecordDao;
import com.notice.domain.NoticeRecordDO;
import com.notice.service.NoticeRecordService;

@Service
public class NoticeRecordServiceImpl implements NoticeRecordService {
	@Autowired
	private NoticeRecordDao recordDao;
	
	@Override
	public NoticeRecordDO get(String id){
		return recordDao.get(id);
	}
	
	@Override
	public List<NoticeRecordDO> list(Map<String, Object> map){
		return recordDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return recordDao.count(map);
	}
	
	@Override
	public int save(NoticeRecordDO record){
		return recordDao.save(record);
	}
	
	@Override
	public int update(NoticeRecordDO record){
		return recordDao.update(record);
	}
	
	@Override
	public int remove(String id){
		return recordDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return recordDao.batchRemove(ids);
	}
	
}
