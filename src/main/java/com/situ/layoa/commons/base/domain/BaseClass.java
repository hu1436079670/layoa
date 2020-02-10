/**
 * @Company:中享思途   
 * @Title:BaseClass.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午5:06:35     
 */ 
package com.situ.layoa.commons.base.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * @ClassName:BaseClass 
 * @Description:(基础类)  
 */
public class BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long rowId;//主键
	private Integer activeFlag;//数据是否有效#1:是;0:否
	private String createBy;//创建人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date createDate;//创建时间
	private String updateBy;//修改人
	private Date updateDate;//修改时间
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
