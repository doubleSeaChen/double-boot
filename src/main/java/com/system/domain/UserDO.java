package com.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author doublesea
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键,UUID
	private String id;
	//用户名
	private String userName;
	private String name;
	//密码
	private String password;
	//性别
	private String sex;
	//归属部门ID
	private String deptId;
	//用户邮箱
	private String email;
	//联系电话
	private String phone;
	//住址
	private String address;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//是否删除
	private Integer isDelete;

	private List<String> roleIds;

	private String headPath;

	/**
	 * 设置：主键,UUID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键,UUID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：归属部门ID
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：归属部门ID
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：用户邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：用户邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：住址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：住址
	 */
	public String getAddress() {
		return address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public String getHeadPath() {
		return headPath;
	}

	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
}
