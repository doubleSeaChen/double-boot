package com.notice.dao;

import com.notice.domain.NoticeRecordDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author doublesea
 */
@Mapper
public interface NoticeRecordDao {

	NoticeRecordDO get(String id);
	
	List<NoticeRecordDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NoticeRecordDO record);
	
	int update(NoticeRecordDO record);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
