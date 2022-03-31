package com.capgemini.bank.services;

import java.util.List;

import com.capgemini.bank.beans.Customer;
import com.capgemini.bank.exception.UserDefinedExceptions;


public interface ICustomerService {
	public List<Customer> addBalance(int accountNo, double addamount, List<Customer> customerList) throws UserDefinedExceptions;

	public List<Customer> withdrawBalance(int accountNo, double withdrawAmmount, List<Customer> customerList) throws UserDefinedExceptions;

	public String checkBalance(int accountNo,List<Customer> customerList);

}