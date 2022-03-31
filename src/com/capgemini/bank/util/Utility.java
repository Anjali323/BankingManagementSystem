package com.capgemini.bank.util;

import com.capgemini.bank.exception.*;

public class Utility {
	public static boolean nameValidation(String r) {
		return r.matches("^[A-Za-z\\s]{3,20}");
	}

	public static boolean phoneValidation(String l) throws UserDefinedExceptions {
		String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		if (l.matches(pattern))
			return true;
		else
			throw new UserDefinedExceptions("Please Enter Valid phone Number.");		
	}
	public static boolean optionValidation(String q) throws UserDefinedExceptions {
		String optionPattern = "[1-7]";
		if (q.matches(optionPattern)) {
			return true;
		} else {
			throw new UserDefinedExceptions("Invalid Option!!");
		}
	}

	public static boolean balanceValidation(String b) throws UserDefinedExceptions {
		String optionPattern =  "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
		if (b.matches(optionPattern)) {
			return true;
		} else {
			throw new UserDefinedExceptions("Please Enter Valid balance.");
		}
	}

	public static boolean accnoValidation(String accno) throws UserDefinedExceptions{
		String regex = "[0-9]+";
		if (accno.matches(regex)) {
			return true;
		} else {
			throw new UserDefinedExceptions("Please Enter Valid Account Number.");
		}
	}
}

