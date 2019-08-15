package com.notice.service.impl;

import com.common.shiro.ShiroTool;
import com.common.tool.MyUtils;
import com.notice.dao.NoticeRecordDao;
import com.notice.domain.NoticeRecordDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.notice.dao.NoticeDao;
import com.notice.domain.NoticeDO;
import com.notice.service.NoticeService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private NoticeRecordDao noticeRecordDao;
	
	@Override
	public NoticeDO get(String id){
		return noticeDao.get(id);
	}
	
	@Override
	public List<NoticeDO> list(Map<String, Object> map){
		map.put("sort","create_date");
		map.put("order","desc");
		return noticeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return noticeDao.count(map);
	}
	
	@Override
	@Transactional
	public int save(NoticeDO notice){
		notice.setId(MyUtils.getUUID32());
		notice.setCreateDate(new Date());
		notice.setCreateUser(ShiroTool.getUserId());

		String[] userIds = notice.getUserIds();
		if(noticeDao.save(notice)>0){
			if(userIds.length>0){
				for(int i=0; i<userIds.length; i++){
					NoticeRecordDO noticeRecordDO = new NoticeRecordDO();
					noticeRecordDO.setId(MyUtils.getUUID32());
					noticeRecordDO.setIsRead(0);
					noticeRecordDO.setNotifyId(notice.getId());
					noticeRecordDO.setUserId(userIds[i]);
					noticeRecordDao.save(noticeRecordDO);
				}
			}
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override
	public int update(NoticeDO notice){
		notice.setUpdateUser(ShiroTool.getUserId());
		notice.setUpdateDate(new Date());
		return noticeDao.update(notice);
	}
	
	@Override
	public int remove(String id){
		return noticeDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return noticeDao.batchRemove(ids);
	}

	@Override
	public List<Map<String, Object>> getNoticeUsers(String noticeId) {
		return noticeDao.getNoticeUsers(noticeId);
	}

	@Override
	public int removeUser(String id) {
		return noticeDao.removeUser(id);
	}
}
