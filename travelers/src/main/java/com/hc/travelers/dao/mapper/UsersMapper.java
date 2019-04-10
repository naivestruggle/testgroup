package com.hc.travelers.dao.mapper;

import com.hc.travelers.custombean.CustomUsers;

public interface UsersMapper {

	void selectByUser(CustomUsers keyUser)throws Exception;

	void insert(CustomUsers valueUser)throws Exception;

}
