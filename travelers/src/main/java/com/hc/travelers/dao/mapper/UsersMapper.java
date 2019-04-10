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
	@Select("select user_id as userId,"
			+ "user_username as userUsername,"
			+ "user_password as userPassword,"
			+ "user_tel as userTel,"
			+ "user_email as userEmail,"
			+ "user_birthday as userBirthday,"
			+ "user_sex as userSex,"
			+ "user_imgpath as userImgpath,"
			+ "user_status as userStatus,"
			+ "user_createtime as userCreatetime")
	List<CustomUsers> selectAll();
	
	
	CustomUsers selectById(int id);
	CustomUsers selectByNamePwd(String username,String password);
	
	@Select("select user_id as userId,"
			+ "user_username as userUsername,"
			+ "user_password as userPassword,"
			+ "user_tel as userTel,"
			+ "user_email as userEmail,"
			+ "user_birthday as userBirthday,"
			+ "user_sex as userSex,"
			+ "user_imgpath as userImgpath,"
			+ "user_status as userStatus,"
			+ "user_createtime as userCreatetime from travelers where user_tel = #{tel}")
	List<CustomUsers> selectByTel(@Param("tel")String tel);
	
	@Select("select count(1) from travelers where user_tel = #{tel}")
	Integer selectByTelToCount(@Param("tel")String tel);
	
	/**
	 * 插入记录   反回插入的
	 * @param valueUser	要插入的对象信息
	 * @return	插入的用户对象
	 * @throws Exception
	 */
	@Insert("insert into travelers(user_username,user_password,user_tel,user_email,"
			+ "user_birthday,user_sex,user_imgpath,user_status,user_createtime)"
			+ "values(#{userUsername},#{user_password},#{user_tel,#{user_email}"
			+ ",#{user_birthday},#{user_sex},#{user_imgpath},#{user_status},"
			+ "#{user_createtime})")
	Integer register(CustomUsers valueUser)throws Exception;

}
