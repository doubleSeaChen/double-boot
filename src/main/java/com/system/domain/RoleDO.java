package com.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author doublesea
 * @email 1992lcg@163.com
 * @date 2018-11-18 13:11:31
 */
public class RoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	private String name;
	private String sign;
	private String remark;
	private Integer isDelete;

	//创建人
	private String createUser;
	//创建时间
	private Date createDate;

	// 角色菜单列表
	private List<String> menuIds;


	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSign() {
		return sign;
	}

	public String getRemark() {
		return remark;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public String getCreateUser() {
		return createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}

	public List<String> getMenuIds() {
		return menuIds;


	}
}
