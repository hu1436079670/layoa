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

import com.situ.layoa.commons.LayResult;
import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
import com.situ.layoa.utils.CodeUtil;
import com.situ.layoa.utils.DAOUtils;

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
		role.setRoleCode(CodeUtil.buildOrderNum());
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
	 * @Description:(根据Id查询实例)
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
		return role == null ? 1 : 0;
	}

	/**
	 * 
	 * @Title: getCount 
	 * @Description:(查询出数据的数量)
	 * @return
	 */
	@Override
	public Integer getCount(Role searchRole) {
		return roleDao.getCount(searchRole);
	}
	
	/**
	 * @Title: findRoleByPage 
	 * @Description:(根据分页查询数据)
	 * @param page		页号
	 * @param limit		每页显示的条数
	 * @param searchRole	查询条件的数据
	 * @return
	 */
	public LayResult findRoleByPage(Integer page,Integer limit,Role searchRole) {
		//通过反射机制将类的实例中的""重新赋值为null,方便MyBatis中多条件查询SQL语句的拼写
		Role searchParam = DAOUtils.buildSearchParam(searchRole);
		//查询出符合条件的一共有多少条记录。
		Integer dataCount = roleDao.getCount(searchParam);
		//根据分页的请求信息查询出数量列表。
		List<Role> roleList = roleDao.findByPage(DAOUtils.buildPagination(page, limit),searchParam);
		return new LayResult(0,"",dataCount,roleList);
	}

}
