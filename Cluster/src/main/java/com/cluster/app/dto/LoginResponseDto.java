package com.cluster.app.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

	private int role;
	private String jwtToken;
	private int userId;
		
}
