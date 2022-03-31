package com.capgemini.bank.services;

import java.util.Comparator;

import com.capgemini.bank.beans.Customer;

public class Sortaccountno implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		if(o1.getAccountNo()>o2.getAccountNo()) 
		return 1;
		else if (o1.getAccountNo()<o2.getAccountNo())
			return -1;
		else
			return 0;
		}

}
