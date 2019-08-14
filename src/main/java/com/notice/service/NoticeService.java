package com.notice.service;

import com.notice.domain.NoticeDO;

import java.util.List;
import java.util.Map;

/**
 * @author doublesea
 */
public interface NoticeService {
	
	NoticeDO get(String id);
	
	List<NoticeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NoticeDO notice);
	
	int update(NoticeDO notice);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<Map<String, Object>> getNoticeUsers(String noticeId);
}
