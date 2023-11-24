package com.mid.repository;

import com.mid.dto.CustomerLoginDTO;

public interface CustomerLoginRespository {

	public CustomerLoginDTO getCustomerLoginByLoginName(String loginName);
}
