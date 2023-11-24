package com.mid.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	
	@SuppressWarnings("finally")
	public String authenticateCustomer(CustomerLoginDTO loginCustomer) throws BankException{
	
	
		String returnValue="FAILED";
		
		Log logger=LogFactory.getLog("com.mid.service");
		
		logger.debug("Inside " + this.getClass());
		
		
		CustomerLoginDTO customercompare=customerLoginRespository.getCustomerLoginByLoginName(loginCustomer.getUsername());
		
	try {	
		if (loginCustomer.getPassword().equals(customercompare.getPassword()))
		{
			returnValue="SUCCESS";
			logger.debug("Login Success in check");
		}
		else 
		{
			
			throw new BankException("FAILED") ;
		}
		
	}
	
	catch(Exception e){
		
		logger.debug("Login Failed " , e);
		throw e;
	}
	
	finally {
		return returnValue;
		
	}
	}

}
