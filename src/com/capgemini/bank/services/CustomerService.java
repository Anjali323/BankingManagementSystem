package com.capgemini.bank.services;

import java.util.List;

import com.capgemini.bank.beans.Customer;
import com.capgemini.bank.exception.UserDefinedExceptions;

public class CustomerService implements ICustomerService{

	@Override
	public List<Customer> addBalance(int accountNo, double addamount, List<Customer> customerList) throws UserDefinedExceptions{
		int ctr=0;
		for (Customer c: customerList) {
			if (c.getAccountNo() == accountNo) {
				double prevBalance = c.getBalance();
				c.setBalance((prevBalance + addamount));
				break;
			}
			else
				ctr++;
		}
		if(ctr==customerList.size())
			throw new UserDefinedExceptions("Account Not Found!");
		return customerList;
	}

	@Override
	public List<Customer> withdrawBalance(int accountNo, double withdrawAmmount, List<Customer> customerList) throws UserDefinedExceptions{
		int ctr=0;
		for (Customer c: customerList) {
			if (c.getAccountNo() == accountNo) {
				double prevBalance = c.getBalance();
				c.setBalance((prevBalance - withdrawAmmount));
				break;
			}
			else
				ctr++;
		}
		if(ctr==customerList.size())
			throw new UserDefinedExceptions("Account Not Found!");
		return customerList;
		}

	@Override
	public String checkBalance(int accountNo, List<Customer> customerList){
		for (Customer i : customerList) {
			if (i.getAccountNo() == accountNo) {
				return "Current balance : " + i.getBalance();
			}
		}
		return "Acount Doesn't Exist!";
	}
	}


