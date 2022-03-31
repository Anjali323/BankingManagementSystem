package com.capgemini.bank.demo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.capgemini.bank.services.AdminServiceImp;
import com.capgemini.bank.services.CustomerService;
import com.capgemini.bank.services.SortName;
import com.capgemini.bank.services.Sortaccountno;
import com.capgemini.bank.util.Utility;
import com.capgemini.bank.exception.UserDefinedExceptions;
import com.capgemini.bank.beans.AccountType;
import com.capgemini.bank.beans.Customer;
public class BankDemo {
	public static void main(String[] args) {
		List<Customer> custList= new ArrayList<Customer>();
		AdminServiceImp ad= new AdminServiceImp(); 
		CustomerService cs= new CustomerService();
		int index=100;
		Scanner sc = new Scanner(System.in);
		boolean cntr=false;
		while (true) {
			int ctrl1=0;
			System.out.println("Press 1 if you are Admin");
			System.out.println("Press 2 if you are Customer");
			System.out.println("Press 3 for Exiting Bank");
			String Choice=sc.next();
			try {
				if (Utility.optionValidation(Choice)) {
					int choice = Integer.parseInt(Choice);
					switch(choice){
						case 1:
							while(true) {
								System.out.println("1. create account for customer");
								System.out.println("2. Display all the customer details");
								System.out.println("3. delete the customer account");
								System.out.println("4. search the customer details");
								System.out.println("5. update customer personal address");
								System.out.println("6. Go Back");
								String Ch = sc.next();
								try {
										if(Utility.optionValidation(Ch)) {
											int ch = Integer.parseInt(Ch);
									switch(ch) {
									case 1:
										
										Customer c = new Customer();
										System.out.println("Enter details of the customer : ");
										System.out.println();
										while(true) {
										System.out.println("Enter customer Name: ");
										String name = sc.next();
										
										if (Utility.nameValidation(name)) {
											c.setCustName(name);
											break;
										}
										else
											System.out.println("Please enter a Valid Name.");
										}
										
										System.out.println("Enter customer address: ");
										c.setCustAddress(sc.next());
										sc.nextLine();
										
										while(true) {
											System.out.println("Enter Phone Number");
											String ph=sc.next();
											try {
												if(Utility.phoneValidation(ph)) {
													c.setCustPhoneNum(Long.parseLong(ph));
													break;
												}
											}catch(UserDefinedExceptions e) {
												System.out.println(e.getMessage());
										}
										}	
										
										sc.nextLine();
										
										while(true) {
										System.out.println("Enter Balance");
										String B=sc.next();
										try {
											if(Utility.balanceValidation(B)) {
												c.setBalance(Double.parseDouble(B));
												break;
											}
										}catch(UserDefinedExceptions e) {
											System.out.println(e.getMessage());
										}
										}
										
										while(true) {
											System.out.println("Enter 1 for Current or 2 for Saving Account Type");
											String K= sc.next();
											try {
												if(Utility.optionValidation(K))
												{
													int k = Integer.parseInt(K);
											if(k==1) {
												c.setAccountType(AccountType.CURRENT);
												break;}
											else if(k==2) {
												c.setAccountType(AccountType.SAVING);
												break;}
											else
												System.out.println("Try Again!");
										}
												}catch(UserDefinedExceptions e) {
													System.out.println(e.getMessage());}
											
											}
										//System.out.println("Enter ACCNO");
										//int4 index=sc.nextInt();
										c.setAccountNo(index);
										custList=ad.addCustomer(c,custList);
										index++;
										break;
									case 2:
										System.out.println("Customer Details: ");
										System.out.println();
										custList=ad.displaycustomers(custList);
										if (custList.isEmpty()) {
											System.out.println("Bank empty!");
											break;
										}
										while(true) {
											System.out.println("Enter 1 to choose sorting by account number");
											System.out.println("Enter 2 to choose sorting by Customer Name");
											String enterSortChoice=sc.next();
											try {
												if(Utility.optionValidation(enterSortChoice)) {
													int enterSortMethod=Integer.parseInt(enterSortChoice);
													switch(enterSortMethod) {
													case 1:
														Collections.sort(custList, new Sortaccountno());
														break;
													case 2:
														Collections.sort(custList, new SortName());
														break;
													}
													break;
												}
											}catch (UserDefinedExceptions e) {
												System.out.println(e.getMessage());
											}
											}
										for (Customer cust:custList) {
											System.out.println(String.format("%5s %25s %25s %15s %15s %15s%n",cust.getAccountNo(),cust.getCustName(),cust.getCustAddress(),cust.getCustPhoneNum(),cust.getBalance(),cust.getAccountType()));
											}
										break;
									case 3:
										String Accno;
										while(true) {
											System.out.println("Enter AccountNo of Customer to be deleted.");
											Accno=sc.next();
											try {
												if(Utility.accnoValidation(Accno)) {
													break;
												}
											}catch(UserDefinedExceptions e) {
												System.out.println(e.getMessage());
										}
										}
											int accno=Integer.parseInt(Accno);
											custList=ad.deleteCustomer(accno, custList);
											System.out.println("Account Successfully Deleted!");
											System.out.println();
											break;
									case 4:
										String Accno1;
										while(true) {
											System.out.println("Enter AccountNo of Customer to be Searched.");
											Accno1=sc.next();
											try {
												if(Utility.accnoValidation(Accno1)) {
													break;
												}
											}catch(UserDefinedExceptions e) {
												System.out.println(e.getMessage());
										}
										}
										int accn=Integer.parseInt(Accno1);
										Customer cust=ad.searchCustomer(accn, custList);
										System.out.println();
										if (cust != null) {
											System.out.println("Account Found!");
											System.out.println(cust.getAccountNo()+"\t|\t"+cust.getCustName()+"\t|\t"+cust.getCustAddress()+"\t|\t"+cust.getCustPhoneNum()+"\t|\t"+cust.getBalance()+"\t|\t"+cust.getAccountType());
										}
										break;
									case 5:
										
										String Accno11;
										while(true) {
											System.out.println("Enter AccountNo of Customer to be Updated.");
											Accno11=sc.next();
											try {
												if(Utility.accnoValidation(Accno11)) {
													break;
												}
											}catch(UserDefinedExceptions e) {
												System.out.println(e.getMessage());
										}
										}
										int accn1=Integer.parseInt(Accno11);
											System.out.println("Ender new Address");
											String newAddress=sc.next();
											custList=ad.updateCustomer(accn1, newAddress, custList);
											System.out.println("Account Successfully Updated!");
											System.out.println();
											break;
									case 6:
										cntr=true;
										break;
										
									default:
										System.out.println("Thanks for your time.");
										
										
									}
									}
									}catch (UserDefinedExceptions e) 
										{
											System.out.println(e.getMessage());
										}
									
								if (cntr) {
									break;
								}
							}
						break;
					case 2:
						Boolean cntr2=false;
						System.out.println("WELCOME CUSTOMER");
						while(true) {
						try { 
						System.out.println("Enter 1 to add money");
						System.out.println("Enter 2 to withdraw money");
						System.out.println("Enter 3 to check balance ");
						System.out.println("Enter 4 Go Back");
						String customerChoice = sc.next();
							if (Utility.optionValidation(customerChoice)) {
								int entChoice = Integer.parseInt(customerChoice);
								switch (entChoice) {
								case 1:
									String accNum;
									while (true) {
										System.out.println("Enter the Account No. in which money is to be added");
										accNum = sc.next(); 
										try {
											if(Utility.accnoValidation(accNum)) {
												break;
											}
										}catch(UserDefinedExceptions e) {
											System.out.println(e.getMessage());
									}
									}
									int accn1=Integer.parseInt(accNum);
									String D;
									while(true) {
											System.out.println("Enter Deposit Amount");
											D=sc.next();
											try {
												if(Utility.balanceValidation(D)) {
													break;
												}
											}catch(UserDefinedExceptions e) {
												System.out.println(e.getMessage());
											}
											}
									Double d=Double.parseDouble(D);
									custList=cs.addBalance(accn1, d,custList);
									System.out.println("Account Successfully Updated!");
									System.out.println();
									
									break;
								case 2:
									String accNum1;
									while (true) {
										System.out.println("Enter the Account No. in which money is to be Withdrawn");
										accNum1 = sc.next(); 
										try {
											if(Utility.accnoValidation(accNum1)) {
												break;
											}
										}catch(UserDefinedExceptions e) {
											System.out.println(e.getMessage());
									}
									}
									int accn11=Integer.parseInt(accNum1);
									String D1;
									while(true) {
											System.out.println("Enter Withdrawal Amount");
											 D1=sc.next();
											try {
												if(Utility.balanceValidation(D1)) {
													break;
												}
											}catch(UserDefinedExceptions e) {
												System.out.println(e.getMessage());
											}
											}
									Double d1=Double.parseDouble(D1);
									custList=cs.withdrawBalance(accn11, d1,custList);
									System.out.println("Account Successfully Updated!");
									
									System.out.println();
		
									break;
								case 3:
									String accNum11;
									while (true) {
										System.out.println("Enter the Account No. to check balance");
										accNum11 = sc.next(); 
										try {
											if(Utility.accnoValidation(accNum11)) {
												break;
											}
										}catch(UserDefinedExceptions e) {
											System.out.println(e.getMessage());
									}
									}
									int acc=Integer.parseInt(accNum11);
									System.out.println(cs.checkBalance(acc, custList));
									System.out.println();
								break;
								case 4:
									cntr2=true;
									break;
								default:
									System.out.println("Invalid Choice!!");
									
							}
							if (cntr2)	
								break;
								}		
							}catch (UserDefinedExceptions e) {
							System.out.println(e.getMessage());}}
							break;
					case 3:
						ctrl1=1;
						sc.close();
						break;
					default:
						System.out.println("Invalid Choice!");
					}
			}
			}catch (UserDefinedExceptions e) {
			System.out.println(e.getMessage());}
			if (ctrl1==1) {
				System.out.println("THANKYOU!");
				break;
				}
		
			}
		System.out.println("-------Bank closed------");
	}
}