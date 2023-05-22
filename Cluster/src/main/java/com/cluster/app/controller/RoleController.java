package com.cluster.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cluster.app.dto.RoleDto;
import com.cluster.app.service.IRoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@GetMapping("/test1")
	public String test1() {
		return "testing1";
	}
		
	@PostMapping("/addrole")
	public ResponseEntity<?> saveRole(@RequestBody RoleDto data){
		return new ResponseEntity<>(roleService.addRole(data),HttpStatus.OK);
	}
	
	
}
