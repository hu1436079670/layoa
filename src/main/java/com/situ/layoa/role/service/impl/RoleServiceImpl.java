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
 * @Description:(RoleServiceImpl)  
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
		role.setActiveFlag(1);
		role.setCreateBy("admin");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	/**
	 * @Title: deleteRole 
	 * @Description:(删除角色信息)
	 * @param rowId
	 */
	@Override
	public Long deleteRole(Long rowId) {
		roleDao.delete(rowId);
		return 1L;
	}

	/**
	 * @Title: updateRole 
	 * @Description:(修改角色信息)
	 * @param role
	 * @return
	 */
	@Override
	public Long updateRole(Role role) {
		role.setUpdateBy("newA");
		role.setUpdateDate(new Date());
		roleDao.update(role);
		return 1L;
	}

	/**
	 * @Title: findAllRole 
	 * @Description:(查询全部角色信息)
	 * @return
	 */
	@Override
	public List<Role> findAllRole() {
		return roleDao.find();
	}

	/**
	 * @Title: getOneRole 
	 * @Description:(查询单个角色信息)
	 * @param rowId
	 * @return
	 */
	@Override
	public Role getOneRole(Long rowId) {
		return roleDao.get(rowId);
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
		if(role==null) {
			bool = 1;
		}
		return bool;
	}

	/**
	 * 
	 * @Title: getCount 
	 * @Description:(查询表中数据的数量)
	 * @return
	 */
	@Override
	public Integer getCount() {
		return roleDao.getCount();
	}

}
