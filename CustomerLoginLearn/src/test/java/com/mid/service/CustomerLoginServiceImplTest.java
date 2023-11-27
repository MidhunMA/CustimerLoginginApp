package com.mid.service;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.mid.dto.CustomerLoginDTO;
import com.mid.exception.BankException;
import com.mid.repository.CustomerLoginRespository;

@SpringBootTest
class CustomerLoginServiceImplTest {

	@Mock
	CustomerLoginRespository customerLoginRepository;
	
	
	
	@InjectMocks
	CustomerLoginServiceImpl customerLoginService;
	
	
	
	@Test
	void authenticateCustomerTestSuccess() throws BankException{
		
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setUsername("midhun");
		customer.setPassword("midhun123");
		
		Mockito.when(customerLoginRepository.getCustomerLoginByLoginName("midhun")).thenReturn(customer);
		
		String stringkk=customerLoginService.authenticateCustomer(customer);
		String actual="SUCCESS";
		Assertions.assertEquals(stringkk,actual);
		
	}
	
	@Test
	void authenticateCustomerTestFailure() throws BankException{

		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setUsername("midhun");
		customer.setPassword("midhun123");
		
		CustomerLoginDTO wrongCustomer = new CustomerLoginDTO();
		wrongCustomer.setUsername("midhun");
		wrongCustomer.setPassword("midhun23");
		
		Mockito.when(customerLoginRepository.getCustomerLoginByLoginName("midhun")).thenReturn(customer);
		
		BankException e=Assertions.assertThrows(BankException.class, ()->customerLoginService.authenticateCustomer(wrongCustomer));
		Assertions.assertEquals("FAILED",e.getMessage());
	}

}
