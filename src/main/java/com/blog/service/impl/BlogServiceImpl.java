package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.blog.dao.BlogDao;
import com.blog.domain.BlogDO;
import com.blog.service.BlogService;
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	
	@Override
	public BlogDO get(String id){
		return blogDao.get(id);
	}
	
	@Override
	public List<BlogDO> list(Map<String, Object> map){
		return blogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return blogDao.count(map);
	}
	
	@Override
	public int save(BlogDO blog){
		return blogDao.save(blog);
	}
	
	@Override
	public int update(BlogDO blog){
		return blogDao.update(blog);
	}
	
	@Override
	public int remove(String id){
		return blogDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return blogDao.batchRemove(ids);
	}
	
}
