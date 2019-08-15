package com.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blog.domain.BlogDO;
import com.common.tool.ParamsForMatter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notice.domain.NoticeDO;
import com.notice.service.NoticeService;

/**
 * 通知通告
 * @author doublesea
 */
 
@Controller
@RequestMapping("/notice/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("notice:notice:notice")
	public Object list(@RequestParam Map<String, Object> params){
		ParamsForMatter currenParams = new ParamsForMatter(params);
		List<NoticeDO> noticeList = noticeService.list(currenParams);
		int total = noticeService.count(currenParams);
		Map<String, Object> data = new HashMap<>();
		data.put("noticeList", noticeList);
		data.put("total", total);
		return data;
	}

	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("notice:notice:add")
	public Object save(@RequestBody NoticeDO notice){
		if(noticeService.save(notice)>0){
			return 1;
		}
		return 0;
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("notice:notice:edit")
	public Object update(@RequestBody NoticeDO notice){
		if(noticeService.update(notice)>0){
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
	@RequiresPermissions("notice:notice:remove")
	public Object remove(@PathVariable("id") String id){
		if(noticeService.remove(id)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@ResponseBody
	@PostMapping("/getNoticeUsers/{noticeId}")
	public Object getNoticeUsers(@PathVariable("noticeId") String noticeId){
		List<Map<String, Object>> noticeUsers = noticeService.getNoticeUsers(noticeId);
		return noticeUsers;
	}

	@PostMapping( "/removeUser/{id}")
	@ResponseBody
	public Object removeUser(@PathVariable("id") String id){
		if(noticeService.removeUser(id)>0){
			return 1;
		}else{
			return 0;
		}
	}
}
