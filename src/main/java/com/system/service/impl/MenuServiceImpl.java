package com.system.service.impl;



import com.system.dao.MenuDao;
import com.system.dao.RoleMenuDao;
import com.system.domain.MenuDO;
import com.system.domain.RoleMenuDO;
import com.system.service.MenuService;
import com.common.shiro.ShiroTool;
import com.common.tool.CreateTree;
import com.common.tool.MyUtils;
import com.common.tool.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Override
	public MenuDO get(String id){
		return menuDao.get(id);
	}
	
	@Override
	public List<MenuDO> list(Map<String, Object> map){
		return menuDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return menuDao.count(map);
	}
	
	@Override
	public int save(MenuDO menu){
		menu.setId(MyUtils.getUUID32());
		menu.setCreateDate(new Date());
		menu.setCreateUser(ShiroTool.getUserId());
		return menuDao.save(menu);
	}
	
	@Override
	public int update(MenuDO menu){
		return menuDao.update(menu);
	}
	
	@Override
	public int remove(String id){
		return menuDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return menuDao.batchRemove(ids);
	}

	@Override
	public Set<String> listSign(String userId) {
		List<String> perms = menuDao.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			// if (StringUtils.isNotBlank(perm)) {
			permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			// }
		}
		return permsSet;
	}

	@Override
	public Tree<MenuDO> getTree() {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuDao.list(new HashMap<>(16));
		for (MenuDO menuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(menuDO.getId().toString());
			tree.setParentId(menuDO.getParentId());
			tree.setText(menuDO.getName());
			tree.setComponent(menuDO.getComponent());
			tree.setPath(menuDO.getRouter());
			tree.setObject(menuDO);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = CreateTree.build(trees);
		return t;
	}

	@Override
	public Tree<MenuDO> getTreeOfNoButton() {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuDao.listOfNoButton(new HashMap<>(16));
		for (MenuDO menuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(menuDO.getId().toString());
			tree.setParentId(menuDO.getParentId());
			tree.setText(menuDO.getName());
			tree.setComponent(menuDO.getComponent());
			tree.setPath(menuDO.getRouter());
			tree.setObject(menuDO);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = CreateTree.build(trees);
		return t;
	}

	@Override
	public Tree<MenuDO> getTree(String userId) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuDao.listByUserId(userId);
		for (MenuDO menuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(menuDO.getId().toString());
			tree.setParentId(menuDO.getParentId().toString());
			tree.setText(menuDO.getName());
			tree.setComponent(menuDO.getComponent());
			tree.setPath(menuDO.getRouter());
			tree.setObject(menuDO);
			tree.setIcon(menuDO.getIcon());
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = CreateTree.build(trees);
		return t;
	}

	@Override
	public Tree<MenuDO> getTreeByRoleId(String roleId) {
		// 获取当前角色关联的菜单列表
		/*List<RoleMenuDO> roleMenuList = roleMenuDao.getByRoleId(roleId);
		// 根据角色菜单列表的菜单列表，查询出该角色的菜单树
		List<MenuDO> menuDOs = new ArrayList<>();
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		roleMenuList.forEach(roleMenuDO ->{
			MenuDO menuDO = new MenuDO();
			menuDO = menuDao.get(roleMenuDO.getMenuId());
			// menuDOs.add(menuDO);

			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(menuDO.getMenuId().toString());
			tree.setParentId(menuDO.getParentId().toString());
			tree.setText(menuDO.getName());
			tree.setObject(menuDO);
			trees.add(tree);
		});
		Tree<MenuDO> t = CreateTree.build(trees);
		return t;*/
		return null;
	}

	@Override
	public List<String> getMenuByRoleId(String roleId) {
		List<RoleMenuDO> roleMenuList = roleMenuDao.getByRoleId(roleId);
		List<String> list = new ArrayList<>();
		roleMenuList.forEach(roleMenuDO -> {
			list.add(roleMenuDO.getMenuId());
		});
		return list;
	}

	@Override
	public List<String> getSignList(String userId) {
		List<String> list = menuDao.listUserPerms(userId);
		return list;
	}
}
