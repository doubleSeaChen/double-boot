package com.blog.dao;

import com.blog.domain.BlogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author doublesea
 */
@Mapper
public interface BlogDao {

	BlogDO get(String id);
	
	List<BlogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BlogDO blog);
	
	int update(BlogDO blog);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
