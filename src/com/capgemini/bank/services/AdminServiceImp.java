package com.capgemini.bank.services;

import java.util.List;

import com.capgemini.bank.beans.Customer;
import com.capgemini.bank.exception.UserDefinedExceptions;

public class AdminServiceImp implements IAdminService {

	@Override
	public List<Customer> addCustomer(Customer c, List<Customer> list) throws UserDefinedExceptions {
		int ctr=0;
		for (Customer c1:list) {
			if(c.getAccountNo()==c1.getAccountNo()) {
				ctr++;
				break;
			}
		}
		if (ctr==1) {
			throw new  UserDefinedExceptions("Account Already Exists!");
		}
		list.add(c);
		return list;
	}
	@Override
	public List<Customer> updateCustomer(int accountNo, String custAddress, List<Customer> list) throws UserDefinedExceptions{
		int ctr=0;
		for (Customer c:list) {					
			if(c.getAccountNo()==accountNo) {
				c.setCustAddress(custAddress);
				
				break;
			}
			else
				ctr++;
		}
		if(ctr==list.size())
			throw new  UserDefinedExceptions("Account Not Found!");
		return list;
	}

	@Override
	public List<Customer> deleteCustomer(int accountNo, List<Customer> list) throws UserDefinedExceptions{
		int ctr=0;
		for (Customer c:list) {
			if(c.getAccountNo()==accountNo) {
				list.remove(c);
				break;
			}
			else
				ctr++;
		}
		if(ctr==list.size())
			throw new  UserDefinedExceptions("Acoount Not Found!");
		return list;
	}

	@Override
	public Customer searchCustomer(int accountNo, List<Customer> list) throws UserDefinedExceptions{
		int ctr=0;
		for (Customer c:list) {
			if(c.getAccountNo()==accountNo) {
				return c;
			}
			else 
				ctr++;
	}
		if (ctr==list.size())
			throw new UserDefinedExceptions("Account Not Found!");
		return null;
	}
	@Override
	public List<Customer> displaycustomers(List<Customer> list) {
		// TODO Auto-generated method stub
		return list;
	}

}
