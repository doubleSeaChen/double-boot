package com.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.tool.ParamsForMatter;
import com.system.domain.LogDO;
import com.system.service.LogService;
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

/**
 * 系统日志
 * 
 * @author doublesea
 * @date 2018-11-18 13:10:19
 */
 
@Controller
@RequestMapping("/sys/log")
public class LogController {
	@Autowired
	private LogService logService;
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:log")
	public Object list(@RequestParam Map<String, Object> params){
		ParamsForMatter currenParams = new ParamsForMatter(params);
		List<LogDO> logList = logService.list(currenParams);
		int total = logService.count(currenParams);
		Map<String, Object> data = new HashMap<>();
		data.put("logList", logList);
		data.put("total", total);
		return data;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public Object save( LogDO log){
		if(logService.save(log)>0){
			return 1;
		}
		return 0;
	}
	
}
