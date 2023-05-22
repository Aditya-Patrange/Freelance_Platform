package com.cluster.app.dto;



import jakarta.annotation.Nonnull;
import lombok.Data;


@Data
public class LoginDto {

	@Nonnull
	private String email;
	@Nonnull
	private String password;
	private String confirmPassword;
	@Nonnull
	private int roleId;
	private int status;
	
	
}
