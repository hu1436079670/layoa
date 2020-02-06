/**
 * @Company:中享思途   
 * @Title:Student.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午3:01:33     
 */ 
package com.situ.layoa.student.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * @ClassName:Student 
 * @Description:(student类)  
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long rowId;//主键
	private String stuName;//学生名称
	private Integer stuAge;//学生年龄
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stuBirthday;//学生生日
	private List<String> stuLikes;//学生爱好
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	public Date getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	public List<String> getStuLikes() {
		return stuLikes;
	}
	public void setStuLikes(List<String> stuLikes) {
		this.stuLikes = stuLikes;
	}
	@Override
	public String toString() {
		return "Student [rowId=" + rowId + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuBirthday="
				+ stuBirthday + ", stuLikes=" + stuLikes + "]";
	}
	
}
