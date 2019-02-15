package com.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:10:31
 */
public class MenuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键，UUID
	private String id;
	//菜单名称
	private String name;
	//上级菜单编号
	private String parentId;
	//标识
	private String sign;
	//菜单类型：1：目录，2：菜单，3：按钮
	private Integer type;
	//排序号
	private Integer order;
	//路由地址
	private String router;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//是否删除
	private Integer isDelete;
	// 组件
	private String component;
	// 图标
	private String icon;

	/**
	 * 设置：主键，UUID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键，UUID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：上级菜单编号
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级菜单编号
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：标识
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * 获取：标识
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * 设置：菜单类型：1：目录，2：菜单，3：按钮
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：菜单类型：1：目录，2：菜单，3：按钮
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：排序号
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 设置：路由地址
	 */
	public void setRouter(String router) {
		this.router = router;
	}
	/**
	 * 获取：路由地址
	 */
	public String getRouter() {
		return router;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：是否删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
