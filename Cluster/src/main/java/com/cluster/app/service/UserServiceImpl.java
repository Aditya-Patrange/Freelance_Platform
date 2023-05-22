package com.cluster.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cluster.app.dto.ApiResponse;
import com.cluster.app.repository.IUserRepository;
import com.cluster.app.utils.CommonUtils;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public ApiResponse<?> getAllRegisteredUsers() {
		//userRepository.findAll();
		return commonUtils.setApiResponses(userRepository.getAllRegisteredUsers()  , "List of all registered users!!", true);
	}

}
