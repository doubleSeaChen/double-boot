package com.notice.dao;

import com.notice.domain.NoticeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author doublesea
 */
@Mapper
public interface NoticeDao {

	NoticeDO get(String id);
	
	List<NoticeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NoticeDO notice);
	
	int update(NoticeDO notice);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
