package com.system.service;


import com.system.domain.MenuDO;
import com.common.tool.Tree;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:10:31
 */
public interface MenuService {
	
	MenuDO get(String id);
	
	List<MenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MenuDO menu);
	
	int update(MenuDO menu);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	Set<String> listSign(String userId);

	/**
	 * 返回树形菜单
	 * @return
	 */
	Tree<MenuDO> getTree();

	Tree<MenuDO> getTreeOfNoButton();

	Tree<MenuDO> getTree(String userId);

	Tree<MenuDO> getTreeByRoleId(String roleId);

	List<String> getMenuByRoleId(String roleId);

	List<String> getSignList(String userId);
}
