package com.hc.travelers.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.runners.Parameterized.Parameters;

import com.hc.travelers.custombean.CustomUsers;

public interface UsersMapper {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<CustomUsers> selectAll()throws Exception;
	
	/**
	 * 根据ID查询用户对象
	 * @param userId	用户ID
	 * @return	用户对象
	 * @throws Exception
	 */
	List<CustomUsers> selectById(@Param("userId") Integer userId)throws Exception;
	
	/**
	 * 根据用户名和密码查询用户对象
	 * @param username	用户名
	 * @param password	密码
	 * @return	用户对象
	 * @throws Exception
	 */
	List<CustomUsers> selectByNamePwd(@Param("username") String username,@Param("password") String password)throws Exception;
	
	/**
	 * 根据手机号查询用户对象
	 * @param userTel	用户手机号
	 * @return	用户对象
	 * @throws Exception
	 */
	List<CustomUsers> selectByTel(@Param("userTel")String userTel)throws Exception;
	
	/**
	 * 根据手机号查询记录数量
	 * @param userTel	手机号
	 * @return	记录数量
	 * @throws Exception
	 */
	@Select("select count(1) from users where user_tel = #{userTel}")
	Integer selectByTelToCount(@Param("userTel")String userTel)throws Exception;
	
	/**
	 * 插入记录   反回插入的
	 * @param valueUser	要插入的对象信息
	 * @return	插入的用户id
	 * @throws Exception
	 */
	void insert(CustomUsers valueUser)throws Exception;
	//insert into users(    user_id,user_username,user_password,user_tel,user_email,user_birthday,user_sex,user_imgpath,user_status,user_createtime   ) values(null,'yxh','123','15570906290','123123@qq.com',null,0,'123123',0,null)

}
