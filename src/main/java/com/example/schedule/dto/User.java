package com.example.schedule.dto;

import lombok.Data;

@Data
public class User {
	private String username;
	private String password;
	private String role;
	private int active;
}
