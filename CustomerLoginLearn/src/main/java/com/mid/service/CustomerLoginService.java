  package com.mid.service;

import com.mid.dto.CustomerLoginDTO;
import com.mid.exception.BankException;

public interface CustomerLoginService {
	
	public String authenticateCustomer(CustomerLoginDTO logingCustomer) throws BankException;
	

}
