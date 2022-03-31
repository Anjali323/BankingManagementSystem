package com.capgemini.bank.services;
import java.util.List;
import com.capgemini.bank.beans.Customer;
import com.capgemini.bank.exception.UserDefinedExceptions;
public interface IAdminService {
	
	public List<Customer> addCustomer(Customer c,List<Customer> list) throws UserDefinedExceptions;
	public List<Customer> updateCustomer(int accountNo, String custAddress,List<Customer> list) throws UserDefinedExceptions;
	public List<Customer> deleteCustomer(int accountNo,List<Customer> list) throws UserDefinedExceptions;	
	public Customer searchCustomer(int accountNo,List<Customer> list) throws UserDefinedExceptions;
	public List<Customer> displaycustomers(List<Customer> list);
}
