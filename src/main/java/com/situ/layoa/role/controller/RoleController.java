/**
 * @Company:中享思途   
 * @Title:RoleController.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月6日 下午7:59:02     
 */
package com.situ.layoa.role.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.layoa.commons.LayResult;
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
	private static final String ROLE_FORM_ADD = "role/role_add_edit";

	@Autowired
	private RoleService roleService;

	// @RequestMapping(path = "/index", method = )
	// @PostMapping method = 'post' 新增动作
	// @PutMapping method = 'put' 修改动作
	// @DeleteMapping method = 'delete' 删除动作
	// @GetMapping method = 'get' 查询动作

	/**
	 * @Title: findAllRole
	 * @Description:(根据分页查询角色的数据)
	 * @param page  请求的页号 1
	 * @param limit 每页的数据量 10
	 * @return
	 */
	@GetMapping("/{page}/{limit}")
	public LayResult findAllRole(@PathVariable Integer page, @PathVariable Integer limit, Role searchRole) {
		return roleService.findRoleByPage(page, limit, searchRole);
//		// System.out.println(page);
//		// System.out.println(limit);
//		// 查询出表中数据的数量
//		Integer count = roleService.getCount();
//		// 模拟进行了分页
//		List<Role> roleList = roleService.findAllRole();
//		return new LayResult(0, "", roleList, count);
	}

	/**
	 * @Title: checkRoleName
	 * @Description:(检测角色名称是否唯一)
	 * @param roleName
	 * @return
	 */
	@GetMapping("/{roleName}")
	public Integer checkRoleName(String roleName) {
		return roleService.checkRoleName(roleName);
	}

	/**
	 * @Title: goAdd
	 * @Description:(进入新增或修改页面)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/goadd")
	public ModelAndView goAddOrEdit(ModelAndView modelAndView) {
		modelAndView.setViewName(ROLE_FORM_ADD);
		return modelAndView;
	}

	/**
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
	 * @Title: doDeleteRole
	 * @Description:(删除角色信息)
	 * @param rowId
	 * @return
	 */
	@DeleteMapping("/{rowId}")
	public Long doDeleteRole(@PathVariable Long rowId) {
		return roleService.deleteRole(rowId);
	}

	/**
	 * @Title: goUpdateRole
	 * @Description:(进入修改)
	 * @param rowId
	 * @return
	 */
	@PutMapping("/{rowId}")
	public Role goUpdateRole(@PathVariable Long rowId) {
		return roleService.getOneRole(rowId);
	}

	/**
	 * @Title: doUpdateROle
	 * @Description:(执行 修改角色信息)
	 * @param role
	 * @return
	 */
	@PutMapping
	public Long doUpdateROle(Role role) {
		return roleService.updateRole(role);
	}
}
