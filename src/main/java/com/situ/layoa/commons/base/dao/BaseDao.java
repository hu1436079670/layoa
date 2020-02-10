/**
 * @Company:中享思途   
 * @Title:BaseDao.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月10日 下午1:30:55     
 */ 
package com.situ.layoa.commons.base.dao;

import java.util.List;

/** 
 * @ClassName:BaseDao 
 * @Description:(这里用一句话描述这个类的作用)  
 */
public interface BaseDao<T> {

	/**
	 * @Title: save 
	 * @Description:(新增)
	 * @param t
	 * @return
	 */
	Long save(T t);
	/**
	 * @Title: delete 
	 * @Description:(删除)
	 * @param rowId
	 */
	void delete(Long rowId);
	/**
	 * @Title: update 
	 * @Description:(修改)
	 * @param t
	 */
	void update(T t);
	/**
	 * @Title: get 
	 * @Description:(根据主键查询记录)
	 * @param rowId
	 * @return
	 */
	T get(Long rowId);
	/**
	 * @Title: find 
	 * @Description:(查询所有的记录)
	 * @return
	 */
	List<T> find();
	
}
