package com.example.schedule.commons;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.schedule.mapper.LoginHistoryMapper;
import com.example.schedule.mapper.UserMapper;

@Component
public class TaskUser {
	@Autowired UserMapper userMapper;
	@Autowired LoginHistoryMapper loginHistoryMapper;
	
	// cron = "초 분 시 일 월 요일" 0 10 15 * * *
	@Scheduled(cron = "0 44 15 * * *") // 모든요일 모든월 모든일 15시 10분 0초
	public void userActiveOnOff() {
		System.out.println("userActiveOnOff 스케줄러 동작");
		// 사용자의 마지막 로그인 날짜가 6개월 지난 사용자를 비활성화 active -> 0
		
		List<Map<String, Object>> list = loginHistoryMapper.selectUserOff();
		if(list == null || list.size() == 0) {
			System.out.println("휴면대상이 없습니다.");
			return;
		}
		
		System.out.println(list.size()+"명의 휴면대상을 휴면처리 합니다");
		for(Map m : list) {
			String username = (String)(m.get("username"));
			userMapper.updateUserActive(username);
			System.out.println(username+"님 휴면처리 되었습니다");
		}
	}
}