package com.example.schedule.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginHistoryMapper {
	@Insert("INSERT INTO login_history(username) VALUES(#{username})")
	int insertLoginHistory(String username);
	
	// 휴면 대상을 조회하는 쿼리
	// 1. 마지막 로그인 날짜가 6개월 이전
	// 2. 현재 active = 1(이미 휴면처리된 계정 제외)
	@Select("""
		SELECT username, MAX(login_date) lastDate
		FROM login_history
		GROUP BY username
		HAVING MAX(login_date) < DATE_SUB(NOW(),INTERVAL 6 MONTH)
	""")
	List<Map<String, Object>> selectUserOff();
}
