package com.cluster.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.RoleDto;
import com.cluster.app.model.RoleEntity;
import com.cluster.app.repository.IRoleRepository;
import com.cluster.app.utils.CommonUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private IRoleRepository roleRepository;
	

	
	
	@Override
	public ApiResponse<?> addRole(RoleDto data) {
		
		RoleEntity roleExist =  roleRepository.findByRoleName(data.getRoleName());
		
		if(roleExist==null) {
			RoleEntity role = new RoleEntity();
			
			role.setRoleName(data.getRoleName());
			return commonUtils.setApiResponses(roleRepository.save(role), "Role added successfull!! ", true);
		}
		
		return commonUtils.setApiResponses(null, "Duplicate role not allowed", false);
	}

}
