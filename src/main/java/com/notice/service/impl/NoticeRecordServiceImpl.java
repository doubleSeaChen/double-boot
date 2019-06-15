package com.notice.service.impl;

import com.common.shiro.ShiroTool;
import com.common.tool.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
	public List<Map<String, Object>> getUserNotice() {
		return recordDao.getUserNotice(ShiroTool.getUserId());
	}

	@Override
	public Map<String, Object> getUserNoticeById(String id) {
		return recordDao.getUserNoticeById(id);
	}

	@Override
	public int setRead(String id) {
		NoticeRecordDO recordDO = recordDao.get(id);
		if(null != recordDO){
			recordDO.setIsRead(1);
			recordDO.setReadDate(new Date());
			return recordDao.update(recordDO);
		}else{
			return 0;
		}
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
