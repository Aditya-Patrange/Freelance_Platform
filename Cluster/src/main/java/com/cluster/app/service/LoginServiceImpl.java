package com.cluster.app.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.LoginDto;
import com.cluster.app.dto.LoginResponseDto;
import com.cluster.app.model.LoginEntity;
import com.cluster.app.repository.ILoginRepository;
import com.cluster.app.repository.IRoleRepository;
import com.cluster.app.repository.IUserStatusRepository;
import com.cluster.app.utils.CommonUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginRepository loginRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginResponseDto loginResponse;
	
	@Autowired
	private IUserStatusRepository userStatusRepository;
	
	@Override
	public ApiResponse<?> signup(LoginDto data) {

		LoginEntity userExist = loginRepository.findByEmail(data.getEmail());

		if (userExist == null) {
			LoginEntity signup = new LoginEntity();
			if (data.getConfirmPassword().equals(data.getPassword())) {
				signup.setEmail(data.getEmail());
				// signup.setPassword(data.getPassword());
				signup.setPassword(passwordEncoder.encode((data.getPassword())));

				signup.setRole(roleRepository.findById(data.getRoleId()).get());
				signup.setStatus(userStatusRepository.findById(data.getStatus()).get());
				LoginEntity  savedEntity =loginRepository.save(signup);
				//loginResponse.setEmail(savedEntity.getEmail());
				loginResponse.setRole(savedEntity.getRole().getRoleId());
				loginResponse.setUserId(savedEntity.getLogId());
				return commonUtils.setApiResponses(loginResponse, "User signup successfully!! ", true);
			} else {
				return commonUtils.setApiResponses(null, "Confirm password doesn't match!! ", false);
			}

		}
		return commonUtils.setApiResponses(null, "User already present!!!", false);
	}

	@Override
	public ApiResponse<?> login(LoginDto data) {

		LoginEntity userExist = loginRepository.findByEmail(data.getEmail());
	
		if (userExist == null) {
			return commonUtils.setApiResponses(null, "User not present , signup first !!", false);
		} else {
			// if(data.getEmail().equals(userExist) );
			// if(userExist.getPassword().equals(data.getPassword()))
		
			if (passwordEncoder.matches(data.getPassword(), userExist.getPassword())) {
				//return commonUtils.setApiResponses(loginRepository.getAllData(data.getEmail()), "Login successfull !",
						//true);
				loginResponse.setRole(userExist.getRole().getRoleId());
				loginResponse.setUserId(userExist.getLogId());
				//loginResponse.setRoleId(userExist.getRole().getRoleId());
				
				
				return commonUtils.setApiResponses(loginResponse, "Login successfull !",true);
			}

			return commonUtils.setApiResponses(null, "Invalid Password ", false);

		}

	}

	@Override
	public ApiResponse<?> updatePassword(LoginDto data) {
		LoginEntity userExist = loginRepository.findByEmail(data.getEmail());
		if (userExist == null) {
			return commonUtils.setApiResponses(null, "User not present , signup first !!", false);
		} else {
			if (data.getConfirmPassword().equals(data.getPassword())) {
				userExist.setPassword(passwordEncoder.encode(data.getPassword()));
				return commonUtils.setApiResponses(loginRepository.save(userExist),
						"User password updated successfully!! ", true);
			} else {
				return commonUtils.setApiResponses(null, "Confirm password doesn't match!! ", false);
			}
		}

	}

	
	public static boolean validateEmail(String email) {
		LoginDto data = new LoginDto();
		
	   String  emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@" 
	        + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
	   Pattern emailPattern = Pattern.compile(emailRegexPattern, Pattern.CASE_INSENSITIVE);
	   Matcher matcher = emailPattern.matcher(email);
	   return matcher.find();
	    
	}
	
}
