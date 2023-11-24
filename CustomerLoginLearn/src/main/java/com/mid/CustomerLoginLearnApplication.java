package com.mid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.mid.controller.CustomerLoginController;
import com.mid.dto.CustomerLoginDTO;
import com.mid.exception.BankException;

@SpringBootApplication
public class CustomerLoginLearnApplication implements CommandLineRunner {

	@Autowired
	CustomerLoginController customerLoginController;
	
	@Autowired
	 Environment environment;
	
	public static Log logger=LogFactory.getLog(CustomerLoginLearnApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerLoginLearnApplication.class, args);
	
	
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	try {
		
		CustomerLoginDTO logingCustomer=new CustomerLoginDTO();
		logingCustomer.setUsername("vishnu");
		logingCustomer.setPassword("vishfuhdd");
		
		
		
		logger.info(environment.getProperty(customerLoginController.authenticateCustomer(logingCustomer)));
		
	} catch (BankException e) {
		// TODO Auto-generated catch block
		logger.error(environment.getProperty(e.getMessage()));
	}
	
	  
	}        
	
	
	
	
	

}
