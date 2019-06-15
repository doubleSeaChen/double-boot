package com.notice.service;

import com.notice.domain.NoticeRecordDO;

import java.util.List;
import java.util.Map;

/**
 * @author doublesea
 */
public interface NoticeRecordService {
	
	NoticeRecordDO get(String id);
	
	List<NoticeRecordDO> list(Map<String, Object> map);

	List<Map<String, Object>> getUserNotice();

	Map<String, Object> getUserNoticeById(String id);

	int setRead(String id);
	
	int count(Map<String, Object> map);
	
	int save(NoticeRecordDO record);
	
	int update(NoticeRecordDO record);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
