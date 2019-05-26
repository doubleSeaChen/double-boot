package com.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.tool.ParamsForMatter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.blog.domain.BlogDO;
import com.blog.service.BlogService;

/**
 * @author doublesea
 */
 
@Controller
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:blog")
	public Object list(@RequestParam Map<String, Object> params){
		ParamsForMatter currenParams = new ParamsForMatter(params);
		List<BlogDO> blogList = blogService.list(currenParams);
		int total = blogService.count(currenParams);
		Map<String, Object> data = new HashMap<>();
		data.put("blogList", blogList);
		data.put("total", total);
		return data;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:add")
	public Object save(@RequestBody BlogDO blog){
		if(blogService.save(blog)>0){
			return 1;
		}
		return 0;
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("blog:edit")
	public Object update(@RequestBody BlogDO blog){
		if(blogService.update(blog)>1){
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove/{id}")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public Object remove(@PathVariable("id") String id){
		if(blogService.remove(id)>0){
			return 1;
		}
		return 0;
	}
	
}
