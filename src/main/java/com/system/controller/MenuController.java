package com.system.controller;

import java.util.List;
import java.util.Map;

import com.system.domain.MenuDO;
import com.system.service.MenuService;
import com.common.tool.Tree;
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
 * @date 2018-11-18 13:10:31
 */
 
@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:menu")
	public List<Tree<MenuDO>> list(@RequestParam Map<String, Object> params){
		//查询列表数据
		/*List<MenuDO> menuList = menuService.list(params);
		return menuList;*/
		// Tree<MenuDO> list = menuService.getTree();
        List<Tree<MenuDO>> list = menuService.getTree().getChildren();
		return list;
	}

	@GetMapping("/treeList")
	@ResponseBody
	@RequiresPermissions("sys:menu")
	List<Tree<MenuDO>>  list(){
		return menuService.getTree().getChildren();
	}

	@PostMapping( "/listByRoleId/{roleId}")
	@ResponseBody
	@RequiresPermissions("sys:menu")
	public List<String> listByRoleId(@PathVariable(value = "roleId") String roleId){
		/*List<Tree<MenuDO>> list = menuService.getTreeByRoleId(roleId).getChildren();
		return list;*/
		List<String> list = menuService.getMenuByRoleId(roleId);
		return list;
	}

	@GetMapping("/listOfNoButton")
	@ResponseBody
	@RequiresPermissions("sys:menu")
	List<Tree<MenuDO>> listOfNoButton(){
		return menuService.getTreeOfNoButton().getChildren();
	}

	@PostMapping("/treeListByUser/{id}")
	@ResponseBody
	// @RequiresPermissions("sys:menu")
	List<Tree<MenuDO>> treeListByUser(@PathVariable(value = "id") String id){
		List<Tree<MenuDO>> list = menuService.getTree(id).getChildren();
		return list;
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:menu:add")
	public Object save(@RequestBody MenuDO menu){
		if(menuService.save(menu)>0){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:menu:update")
	public Object update(@RequestBody  MenuDO menu){
		if(menuService.update(menu)>0){
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
	@RequiresPermissions("sys:menu:delete")
	public Object remove(@PathVariable("id") String id){
		if(menuService.remove(id)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@PostMapping( "/signList/{userId}")
	@ResponseBody
	public Object signList(@PathVariable("userId") String userId){
		return menuService.getSignList(userId);
	}
	
}
