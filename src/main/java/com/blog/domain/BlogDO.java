package com.blog.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 * @author doublesea
 */
public class BlogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//标题
	private String title;
	//内容
	private String content;
	//类型
	private String type;
	//标签
	private String tags;
	//分类
	private String categories;
	//评论数量
	private Integer commentsNum;
	//状态
	private Integer status;
	//创建人id
	private Long createdUser;
	//修改人id
	private Long updateUser;
	//作者
	private String author;
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;

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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：标签
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：标签
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * 设置：分类
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}
	/**
	 * 获取：分类
	 */
	public String getCategories() {
		return categories;
	}
	/**
	 * 设置：评论数量
	 */
	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}
	/**
	 * 获取：评论数量
	 */
	public Integer getCommentsNum() {
		return commentsNum;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getCreatedUser() {
		return createdUser;
	}
	/**
	 * 设置：修改人id
	 */
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人id
	 */
	public Long getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
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
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
