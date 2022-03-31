package com.capgemini.bank.beans;

public class Customer {
	
	private long accountNo;
	private String custName;
	private String custAddress;
	private long custPhoneNum;
	private double balance;
	private AccountType accountType;
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public long getCustPhoneNum() {
		return custPhoneNum;
	}
	public void setCustPhoneNum(long custPhoneNum) {
		this.custPhoneNum = custPhoneNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custPhoneNum=" + custPhoneNum + ", balance=" + balance + ", accountType=" + accountType + "]";
	}
	

	
	}
