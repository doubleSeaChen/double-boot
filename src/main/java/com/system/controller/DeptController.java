package com.system.controller;

import com.common.tool.Tree;
import com.system.domain.DeptDO;
import com.system.domain.MenuDO;
import com.system.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 部门管理
 * @author doublesea
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
	@GetMapping("/listTree")
	@RequiresPermissions("system:dept:dept")
	public List<Tree<DeptDO>> listTree(@RequestParam Map<String, Object> params){
		List<Tree<DeptDO>> list = deptService.getTree().getChildren();
		return list;
	}

	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:dept:add")
	public Object save(@RequestBody DeptDO dept){
		if(deptService.save(dept)>0){
			return 1;
		}else{
			return 0;
		}
	}
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:dept:edit")
	public Object update(@RequestBody DeptDO dept){
		if(deptService.update(dept)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@PostMapping( "/remove/{id}")
	@ResponseBody
	@RequiresPermissions("system:dept:remove")
	public Object remove(@PathVariable("id") String id){
		if(deptService.remove(id)>0){
			return 1;
		}else{
			return 0;
		}
	}

}
