/**
 * @Company:中享思途   
 * @Title:RoleDao.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午5:10:54     
 */ 
package com.situ.layoa.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.layoa.role.domain.Role;

/** 
 * @ClassName:RoleDao 
 * @Description:(角色Dao层)  
 */
@Repository
public interface RoleDao {
	
	/**
	 * 
	 * @Title: save 
	 * @Description:(新增)
	 * @param role
	 * @return
	 */
	Long save(Role role);
	/**
	 * 
	 * @Title: delete 
	 * @Description:(删除)
	 * @param rowId
	 */
	void delete(Long rowId);
	/**
	 * 
	 * @Title: update 
	 * @Description:(修改)
	 * @param role
	 */
	void update(Role role);
	/**
	 * 
	 * @Title: find 
	 * @Description:(查询全部角色信息)
	 * @return
	 */
	List<Role> find();
	/**
	 * 
	 * @Title: get 
	 * @Description:(查询单个信息)
	 * @param rowId
	 * @return
	 */
	Role get(Long rowId);
	/**
	 * 
	 * @Title: checkRoleName 
	 * @Description:(检测角色名称是否唯一)
	 * @param roleName
	 * @return
	 */
	Role checkRoleName(String roleName);
	/**
	 * 
	 * @Title: getCount 
	 * @Description:(查询出表中数据的数量)
	 * @return
	 */
	Integer getCount();
}
