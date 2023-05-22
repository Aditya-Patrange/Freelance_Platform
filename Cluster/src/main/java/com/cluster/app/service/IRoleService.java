package com.cluster.app.service;

import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.ProjectDto;
import com.cluster.app.dto.RoleDto;

public interface IRoleService {

	
	ApiResponse<?> addRole(RoleDto data);
}
