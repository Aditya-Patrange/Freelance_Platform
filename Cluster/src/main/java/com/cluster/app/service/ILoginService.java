package com.cluster.app.service;

import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.LoginDto;


public interface ILoginService {

	ApiResponse<?> signup(LoginDto data);

	ApiResponse<?> login(LoginDto data);

	ApiResponse<?> updatePassword(LoginDto data);


	
	
}
