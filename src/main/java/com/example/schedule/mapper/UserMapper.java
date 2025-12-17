package com.example.schedule.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.schedule.dto.User;

@Mapper
public interface UserMapper {
	@Select("SELECT username FROM user WHERE username = #{username} AND password = #{password}")
	User login(User user);
	
	// 휴먼상태로 전환하는 쿼리
	@Update("""
		UPDATE user SET active=0 WHERE username=#{username}
	""")
	int updateUserActive(String username);
}
