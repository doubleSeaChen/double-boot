package com.notice.service.impl;

import com.common.shiro.ShiroTool;
import com.common.tool.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.notice.dao.NoticeDao;
import com.notice.domain.NoticeDO;
import com.notice.service.NoticeService;



@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
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
	public int save(NoticeDO notice){
		notice.setId(MyUtils.getUUID32());
		notice.setCreateDate(new Date());
		notice.setCreateUser(ShiroTool.getUserId());
		return noticeDao.save(notice);
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
	
}
