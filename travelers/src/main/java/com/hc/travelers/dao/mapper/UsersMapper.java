package com.hc.travelers.dao.mapper;

import java.util.List;

import com.hc.travelers.custombean.CustomUsers;

public interface UsersMapper {

	/**
	 * 根据用户查询
	 * @param keyUser	查询条件
	 * @return	查询到的用户对象集合
	 * @throws Exception
	 */
	List<CustomUsers> selectByUser(CustomUsers keyUser)throws Exception;

	/**
	 * 插入记录   反回插入的
	 * @param valueUser	要插入的对象信息
	 * @return	插入的用户对象
	 * @throws Exception
	 */
	CustomUsers insert(CustomUsers valueUser)throws Exception;

}
