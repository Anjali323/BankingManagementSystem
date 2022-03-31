package com.capgemini.bank.services;

import java.util.Comparator;

import com.capgemini.bank.beans.Customer;

public class SortName implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
			if(o1.getCustName().compareTo(o2.getCustName())>0)
				return 1;
			else if(o1.getCustName().compareTo(o2.getCustName())<0)
				return -1;
			else
				return 0;
	}

}
