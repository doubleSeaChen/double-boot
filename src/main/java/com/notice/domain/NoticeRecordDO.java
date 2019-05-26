package com.notice.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 通知通告发送记录
 * @author doublesea
 */
public class NoticeRecordDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private String id;
	//通知通告ID
	private String notifyId;
	//接受人
	private String userId;
	//阅读标记
	private Integer isRead;
	//阅读时间
	private Date readDate;

	/**
	 * 设置：编号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：编号
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：通知通告ID
	 */
	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}
	/**
	 * 获取：通知通告ID
	 */
	public String getNotifyId() {
		return notifyId;
	}
	/**
	 * 设置：接受人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：接受人
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：阅读标记
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	/**
	 * 获取：阅读标记
	 */
	public Integer getIsRead() {
		return isRead;
	}
	/**
	 * 设置：阅读时间
	 */
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	/**
	 * 获取：阅读时间
	 */
	public Date getReadDate() {
		return readDate;
	}
}
