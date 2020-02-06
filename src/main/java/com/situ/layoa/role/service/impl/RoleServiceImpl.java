/**
 * @Company:中享思途   
 * @Title:RoleServiceImpl.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午7:45:26     
 */ 
package com.situ.layoa.role.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

/** 
 * @ClassName:RoleServiceImpl 
 * @Description:(这里用一句话描述这个类的作用)  
 */
@Service
public class RoleServiceImpl implements Serializable, RoleService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RoleDao roleDao;

	/** 
	 * @Title: saveRole 
	 * @Description:(新增角色信息)
	 * @param role
	 * @return  
	 */
	@Override
	public Long saveRole(Role role) {
		role.setRoleCode("11111");
		role.setActiveFlag(1);
		role.setCreateBy("admin");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	/** 
	 * @Title: deleteRole 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param rowId  
	 */
	@Override
	public void deleteRole(Long rowId) {
		// TODO Auto-generated method stub

	}

	/** 
	 * @Title: updateRole 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param role
	 * @return  
	 */
	@Override
	public Long updateRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * @Title: findAllRole 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @return  
	 */
	@Override
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * @Title: getOneRole 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param rowId
	 * @return  
	 */
	@Override
	public Role getOneRole(Long rowId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @Title: checkRoleName 
	 * @Description:(检测角色名称是否唯一)
	 * @param roleName
	 * @return
	 */
	@Override
	public Integer checkRoleName(String roleName) {
		Role role = roleDao.checkRoleName(roleName);
		int bool = 0;
		if(role!=null) {
			bool = 1;
		}
		return bool;
	}

}
