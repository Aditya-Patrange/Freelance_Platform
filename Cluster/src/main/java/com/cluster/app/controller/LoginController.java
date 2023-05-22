package com.cluster.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cluster.app.dto.LoginDto;
import com.cluster.app.service.ILoginService;
import com.cluster.app.service.IUserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/test3")
	public String test3() {
		return "testing3!!";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody LoginDto data){
		return new ResponseEntity<>(loginService.signup(data),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginDto data){
		return new ResponseEntity<>(loginService.login(data),HttpStatus.OK);
	}
	
	@PutMapping("/updatepassword")
	public ResponseEntity<?> updatePassword(@RequestBody LoginDto data){
		return new ResponseEntity<>(loginService.updatePassword(data),HttpStatus.OK);
	}
	
	@GetMapping("/getallregitereduser")
	public ResponseEntity<?> getAllRegisteredUsers(){
		return new ResponseEntity<>(this.userService.getAllRegisteredUsers(),HttpStatus.OK);
	}
	
	

}
