package com.webapp;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

	public boolean isValidUser(String user,String password){
		if(user.equals("Mohammad")&password.equals("dummy"))
			return true;
		return false;
	}
	
	
}
