/**
 * @Company:中享思途   
 * @Title:RoleController.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午7:59:02     
 */ 
package com.situ.layoa.role.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

/** 
 * @ClassName:RoleController 
 * @Description:(roleController层)  
 */
@RestController
@RequestMapping("/role")
public class RoleController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleService roleService;
	
	/**
	 * 
	 * @Title: doAddRole 
	 * @Description:(新增角色信息)
	 * @param role
	 * @return
	 */
	@PostMapping
	public Long doAddRole(Role role) {
		return roleService.saveRole(role);
	}
	/**
	 * 
	 * @Title: checkRoleName 
	 * @Description:(检测角色名称是否唯一)
	 * @param roleName
	 * @return
	 */
	@PostMapping("/{roleName}")
	public Integer checkRoleName(String roleName) {
		int bool = roleService.checkRoleName(roleName);
		return bool;
		
	}
}
