package com.example.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.schedule.dto.User;
import com.example.schedule.mapper.LoginHistoryMapper;
import com.example.schedule.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired UserMapper userMapper;
	@Autowired LoginHistoryMapper loginHistoryMapper;
	
	@GetMapping("/main")
	public String main() {
		return "main"; // 반갑습니다. 로그아웃
	}
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, User user) {
		User loginUser = userMapper.login(user);
		if(loginUser == null) { // 로그인 실패
			return "redirect:/";
		}
		// 로그인 성공시 날짜시간 기록
		loginHistoryMapper.insertLoginHistory(loginUser.getUsername());
		session.setAttribute("loginUser", loginUser);
		return "redirect:/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}