package com.cluster.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.LoginResponseDto;

public interface IUserService {

	ApiResponse<?> getAllRegisteredUsers();
}
