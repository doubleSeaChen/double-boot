package com.notice.controller;

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

import com.notice.domain.NoticeRecordDO;
import com.notice.service.NoticeRecordService;

/**
 * 通知公告记录
 * @author doublesea
 */
 
@Controller
@RequestMapping("/notice/record")
public class NoticeRecordController {
	@Autowired
	private NoticeRecordService recordService;

	@ResponseBody
	@GetMapping("/getUserNotice")
	public Object getUserNotice(){
		List<Map<String, Object>> list = recordService.getUserNotice();
		return list;
	}

	@ResponseBody
	@PostMapping("/getUserNoticeById/{id}")
	public Object getUserNoticeById(@PathVariable("id") String id){
		Map<String, Object> data = recordService.getUserNoticeById(id);
		return data;
	}

	@ResponseBody
	@PostMapping("/setRead/{id}")
	public Object setRead(@PathVariable("id") String id){
		return recordService.setRead(id);
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("notice:record:record")
	public Object list(@RequestParam Map<String, Object> params){
		ParamsForMatter currenParams = new ParamsForMatter(params);
		List<NoticeRecordDO> recordList = recordService.list(currenParams);
		int total = recordService.count(currenParams);
		Map<String, Object> data = new HashMap<>();
		data.put("recordList", recordList);
		data.put("total", total);
		return data;
	}

	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("notice:record:add")
	public Object save(@RequestBody NoticeRecordDO record){
		if(recordService.save(record)>0){
			return 1;
		}
		return 0;
	}


}
