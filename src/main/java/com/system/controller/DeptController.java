package com.system.controller;

import com.system.domain.DeptDO;
import com.system.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 部门管理
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:09:56
 */
 
@Controller
@RequestMapping("/system/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:dept:dept")
	public Object list(@RequestParam Map<String, Object> params){
		//查询列表数据
       return null;
	}

	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:dept:add")
	public Object save( DeptDO dept){
		/*if(deptService.save(dept)>0){
			return R.ok();
		}
		return R.error();*/
		return null;
	}
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:dept:edit")
	public Object update( DeptDO dept){
		/*deptService.update(dept);
		return R.ok();*/
		return null;
	}

	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:dept:remove")
	public Object remove( String id){
		/*if(deptService.remove(id)>0){
		return R.ok();
		}
		return R.error();*/
		return null;
	}

	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:dept:batchRemove")
	public Object remove(@RequestParam("ids[]") String[] ids){
		/*deptService.batchRemove(ids);
		return R.ok();*/
		return null;
	}
	
}
