/**
 * @Company:中享思途   
 * @Title:RoleService.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午5:19:48     
 */ 
package com.situ.layoa.role.service;

import java.util.List;

import com.situ.layoa.role.domain.Role;

/** 
 * @ClassName:RoleService 
 * @Description:(roleService层)  
 */
public interface RoleService {

	/**
	 * @Title: saveRole 
	 * @Description:(新增角色信息)
	 * @param role
	 * @return
	 */
	Long saveRole(Role role);
	/**
	 * @Title: deleteRole 
	 * @Description:(删除角色信息)
	 * @param rowId
	 */
	Long deleteRole(Long rowId);
	/**
	 * @Title: updateRole 
	 * @Description:(修改角色信息)
	 * @param role
	 * @return
	 */
	Long updateRole(Role role);
	/**
	 * @Title: findAllRole 
	 * @Description:(查询全部角色信息)
	 * @return
	 */
	List<Role> findAllRole();
	/**
	 * @Title: getOneRole 
	 * @Description:(查询单个角色信息)
	 * @param rowId
	 * @return
	 */
	Role getOneRole(Long rowId);
	/**
	 * @Title: checkRoleName 
	 * @Description:(检测角色名称是否唯一)
	 * @param roleName
	 * @return
	 */
	Integer checkRoleName(String roleName);
	/**
	 * 
	 * @Title: getCount 
	 * @Description:(查询表中数据的数量)
	 * @return
	 */
	Integer getCount();
}
