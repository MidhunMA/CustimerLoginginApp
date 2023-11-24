package com.mid.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mid.dto.CustomerLoginDTO;
@Repository(value="customerLoginRepository")
public class CustomerLoginRepositoryImpl implements  CustomerLoginRespository  {

	public CustomerLoginDTO getCustomerLoginByLoginName(String loginName) {
		
		CustomerLoginDTO customerLogin= new CustomerLoginDTO();
		Map<String,String> custDatabase = new HashMap<String,String>();
		
		custDatabase.put("midhun", "midhun123");
		custDatabase.put("ajessh", "ajessh123");
		custDatabase.put("sarath", "sarathjjd");
		custDatabase.put("vishnu", "vishfaadd");
		customerLogin.setUsername(loginName);
		customerLogin.setPassword(custDatabase.get(loginName));
		
		return customerLogin;
		
	}
	
}
