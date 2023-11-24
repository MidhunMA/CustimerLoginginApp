package com.mid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mid.dto.CustomerLoginDTO;
import com.mid.exception.BankException;
import com.mid.service.CustomerLoginService;

@Controller(value="customerLoginController")
public class CustomerLoginController {

	@Autowired
	 CustomerLoginService customerLoginService;
	
	public  String authenticateCustomer(CustomerLoginDTO logingCustomer) throws BankException{
		
		String Resultlogin=null;
		
		Resultlogin=customerLoginService.authenticateCustomer(logingCustomer);
		
		return Resultlogin;
	}

}