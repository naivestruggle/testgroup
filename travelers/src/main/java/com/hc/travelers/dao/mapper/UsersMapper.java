package com.hc.travelers.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	List<CustomUsers> selectByTel(@Param("account")String userTel)throws Exception;
	/**
	 * 根据邮箱查询用户对象
	 * @param userMail 用户邮箱
	 * @return 用户对象
	 * @throws Exception
	 */
	List<CustomUsers> selectByMail(@Param("account")String userMail)throws Exception;
	
	/**
	 * 根据手机号查询记录数量
	 * @param userTel	手机号
	 * @return	记录数量
	 * @throws Exception
	 */
	@Select("select count(1) from users where user_tel = #{account}")
	Integer selectByTelToCount(@Param("account")String userTel)throws Exception;
	
	/**
	 * 插入记录   反回插入的
	 * @param valueUser	要插入的对象信息
	 * @return	插入的用户id
	 * @throws Exception
	 */
	void insert(CustomUsers valueUser)throws Exception;
	
	/**
	 * 根据邮箱号查询记录数
	 * @param userEmail 邮箱号
	 * @return 记录数量
	 * @throws Exception
	 */
	@Select("select count(1) from users where user_email = #{account}")
	Integer selectByMailToCount(@Param("account")String userEmail) throws Exception;

	/**
	 * 根据手机号修改密码
	 * @param userTel	手机号
	 * @param userPassword	
	 * @throws Exception
	 */
	@Update("update users set user_password = #{userPassword} where user_tel = #{userTel}")
	void updatePwdByTel(@Param("userTel")String userTel,@Param("userPassword")String userPassword)throws Exception;

	/**
	 * 根据邮箱地址修改密码
	 * @param userEmail
	 * @param password
	 */
	@Update("update users set user_password = #{userPassword} where user_email = #{userEmail}")
	void updatePwdByEmail(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);
	

	
}
