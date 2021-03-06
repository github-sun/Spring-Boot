package org.sun.bootapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;
import org.sun.bootapp.entity.User;

@Mapper
public interface UserDAO {

	@Select("SELECT * FROM USERS WHERE id = #{id}")
	User queryUserById(@Param("id") int id);
	
	@Select("SELECT * FROM USERS ORDER BY DATE DESC")
	List<User> queryUsers();
	
	@Insert("INSERT INTO USERS(id,name,sex,age,date) VALUES(#{id}, #{name},#{sex}, #{age},#{date})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
	@Transactional
	int insertUser(User user);
	
	@Delete("DELETE FROM USERS WHERE id =#{id}")
	@Transactional
	int deleteUserById(@Param("id") int id);
	
	
	@Update("UPDATE USERS SET name=#{name},sex=#{sex},age=#{age},date=#{date} WHERE id=#{id}")
	@Transactional
	int updateUser(User user);
}
