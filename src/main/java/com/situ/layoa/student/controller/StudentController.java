/**
 * @Company:中享思途   
 * @Title:StudentController.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午3:07:26     
 */
package com.situ.layoa.student.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.layoa.student.domain.Student;

/**
 * @ClassName:StudentController
 * @Description:(student控制层)
 */
@RestController
@RequestMapping("/student")
public class StudentController implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @Title: doAddStudent
	 * @Description:(新增)
	 * @param student
	 * @return
	 */
	@PostMapping
	public Long doAddStudent(Student student) {
		student.toString();
		return 1L;
	}

	/**
	 * 
	 * @Title: checkStuName
	 * @Description:(学生名称的唯一性校验)
	 * @param stuName
	 * @return 1：可以使用；0：不可以使用
	 */
	@GetMapping("/checkStuName")
	public Integer checkStuName(String stuName) {
		System.out.println("校验");
		Integer result = 1;
		if ("lisi".equals(stuName)) {
			result = 0;
		}
		return result;
	}
}
