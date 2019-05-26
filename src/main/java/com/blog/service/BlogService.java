package com.blog.service;

import com.blog.domain.BlogDO;

import java.util.List;
import java.util.Map;

/**
 * @author doublesea
 */
public interface BlogService {
	
	BlogDO get(String id);
	
	List<BlogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BlogDO blog);
	
	int update(BlogDO blog);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
