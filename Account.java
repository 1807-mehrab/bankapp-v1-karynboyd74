package com.revature.bankApp;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {
	int accountNumber;
	float balance = 0;
	Scanner get = new Scanner(System.in);
	
	Account() {
		// this needs to be SQL PS (or SPs)

		// "SELECT * FROM ACCOUNT WHERE acctId = accountNumber"
		// Store that ResultSet in balance 
		/* ^ replaces //System.out.println("Enter initial balance: ");
		balance = get.nextFloat(); */
	}

	public void deposit() {
		byte s_id = 1;
		byte c_id = 1;
		double deposit_amount = 0;
		
        System.out.println("Enter the amount you would like to deposit: ");      
        deposit_amount = get.nextDouble();
        if (deposit_amount <= 0) {
            System.out.println("Invalid amount entered. Please enter a dollar amount greater than $0.00. ");
           } else {
        	   
        	   try {
        		   // 1st ? = s_id --> savings_acct.saveid; 2nd ? = c_id --> check_account.checkid; last ? = deposit_amount --> pulls from user input
        		   CallableStatement spDeposit = ConnectDB.prepareCall("{ call SP_DEPOSIT(?,?,?)}");
        		   System.out.println("Please enter the savings account number you would like to transfer the deposit from (1 - 5): ");
        		   s_id = get.nextByte();
        		   System.out.println("Please enter the checking account number you would like to transfer the deposit into (1 - 5): ");
        		   c_id = get.nextByte();
        	   
        		   // Exception in thread "main" java.lang.NullPointerException
        		   spDeposit.setByte(1,s_id);
        		   spDeposit.setByte(2,c_id);
        		   spDeposit.setDouble(3, deposit_amount);        	   
        		   spDeposit.execute();
        	   
        		   System.out.println("Deposit made.");
        	   } catch (SQLException ex) {
        		   ex.printStackTrace();
        	   }

        	   
        	   // balance = balance += amount;
        	   // System.out.println("$" + amount + " has been deposited.");
        	   // System.out.println("Your balance is now: $" + balance);
           }	
	}

	public void withdraw() {
		float amount;
		System.out.println("Enter withdrawal amount: ");
		amount = get.nextFloat();
		// should use balance from Account SELECT query
		if(amount < balance) {
			balance = balance - amount;
			System.out.println("$" + amount + " withdrawn. Current account balance is $");
		} 
		else {
			System.out.println("Insufficient funds.");
		}
		
	}
	
	public void exit() {
		boolean exit = false;
		if (exit != false) {
			Menu m = new Menu();
			m.displayMenu();
		}
		else {
			System.out.println("Goodbye!");
			ConnectDB.close();
		}
	}
	
	public float showBalance() {
		return balance;	
	}

}
