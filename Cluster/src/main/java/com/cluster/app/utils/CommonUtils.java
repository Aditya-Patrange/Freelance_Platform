package com.cluster.app.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cluster.app.dto.ApiResponse;


@Component
public class CommonUtils {

	@Autowired
	private ModelMapper mapper;
	
	
	public ApiResponse<?> setApiResponses(Object data, String message, boolean b) {
		
		ApiResponse<Object> apiResponse = new ApiResponse<>();
		apiResponse.setMessage(message);

		apiResponse.setData(data);
		
		apiResponse.setSuccess(b);
		return apiResponse;
	}
}
