package com.system.domain;

import java.io.Serializable;


/**
 * 角色与菜单对应关系
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-05 22:47:27
 */
public class RoleMenuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//角色ID
	private String roleId;
	//菜单ID
	private String menuId;
	private String createUser;
	private String createDate;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色ID
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：菜单ID
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：菜单ID
	 */
	public String getMenuId() {
		return menuId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
