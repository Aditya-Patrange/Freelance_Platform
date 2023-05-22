package com.cluster.app.dto;

import lombok.Data;

@Data
public class UserStatusDto {

	private String email;
	private int roleId;
	private int status;
}
