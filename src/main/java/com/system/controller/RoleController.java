package com.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.system.domain.RoleDO;
import com.system.service.RoleService;
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


/**
 * 
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:11:31
 */
 
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:role")
	public Object list(@RequestParam Map<String, Object> params){
		Map<String, Object> currenParams = new HashMap<>();
		currenParams.put("offset", Integer.valueOf(params.get("offset").toString()));
		currenParams.put("limit", Integer.valueOf(params.get("limit").toString()));
		List<RoleDO> roleList = roleService.list(currenParams);
		int total = roleService.count(currenParams);
		Map<String, Object> data = new HashMap<>();
		data.put("roleList", roleList);
		data.put("total", total);
		return data;
	}

	@ResponseBody
	@GetMapping("/listAll")
	@RequiresPermissions("sys:role")
	public Object listAll(@RequestParam Map<String, Object> params){
		List<RoleDO> roleList = roleService.list(params);
		return roleList;
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:role:add")
	public Object save(@RequestBody RoleDO role){
		if(roleService.save(role)>0){
			return 1;
		}
		return 0;
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:role:update")
	public Object update(@RequestBody RoleDO role){
		if(roleService.update(role)>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove/{id}")
	@ResponseBody
	@RequiresPermissions("sys:role:delete")
	public Object remove(@PathVariable("id") String id){
		if(roleService.remove(id)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@PostMapping("/listByUserId/{userId}")
	@ResponseBody
	@RequiresPermissions("sys:role")
	public Object listByUserId(@PathVariable("userId") String userId){
		return roleService.getByUserId(userId);
	}
}
