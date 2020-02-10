/**
 * @Company:中享思途   
 * @Title:RoleDao.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午5:10:54     
 */ 
package com.situ.layoa.role.dao;


import org.springframework.stereotype.Repository;

import com.situ.layoa.commons.base.dao.BaseDao;
import com.situ.layoa.role.domain.Role;

/** 
 * @ClassName:RoleDao 
 * @Description:(角色Dao层)  
 */
@Repository
public interface RoleDao extends BaseDao<Role> {

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
