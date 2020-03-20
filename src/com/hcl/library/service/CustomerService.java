package com.hcl.library.service;

import java.util.Optional;
import java.util.function.Predicate;

import com.hcl.library.dao.CustomerDao;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.model.po.CustomerPO;

public class CustomerService {
	private CustomerDao customerDao;
	
	private CustomerService() {
		customerDao= new CustomerDao();
	}
	
	//create the curstomer if does not exist 
	public boolean creatCustomer(CustomerPO customer) {
		String name= customer.getName();
		Predicate<CustomerPO> sameName= customerName-> customer.getName().equals(name);
		Optional<CustomerPO> customerExist= customerDao.findAll().stream().filter(sameName).findAny();
		
			if(customerExist.isPresent()) {
				System.out.println("The customer is already in the system");
				return false;
			}else {
				customerDao.create(customer);
				return true;
			}
	}
	//update a customer already create
	public void updateCustomer(CustomerPO customer) {
		customerDao.update(customer);
	}
	
	//search a customer
	public CustomerPO findByName(String name) {
		return customerDao.find(customerDao.criteriaOfSearching(name, "getName"));
	}
	
}
