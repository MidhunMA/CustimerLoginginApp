package com.mid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mid.dto.CustomerLoginDTO;
import com.mid.exception.BankException;
import com.mid.repository.CustomerLoginRespository;


@Service(value="customerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService  {
	

	@Autowired
	CustomerLoginRespository customerLoginRespository;
	
	@Autowired
	Environment properties;
	
	
	public String authenticateCustomer(CustomerLoginDTO loginCustomer) throws BankException{
	
	
		String returnValue="FAILED";
		
		CustomerLoginDTO customercompare=customerLoginRespository.getCustomerLoginByLoginName(loginCustomer.getUsername());
			
		if (loginCustomer.getPassword().equals(customercompare.getPassword()))
		  {
			returnValue="SUCCESS";
			
		   }
		else 
		  {			
			throw new BankException("FAILED") ;		
		  }
		return returnValue;	   
	}	
}
	



