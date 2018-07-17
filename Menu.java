package com.revature.bankApp;

import java.util.Scanner;

public class Menu {
	private Scanner get;

	Menu() {
		
	}
	
	public void displayMenu() {
		get = new Scanner(System.in);
		int selection;
		boolean exit = false;
		double deposit_amount = 0;
        do {
            System.out.println("Welcome to the Bank of Boyd! Please make your selection from the following menu.");
            System.out.println("Select 1 for Deposit.");
            System.out.println("Select 2 for Withdrawal.");
            System.out.println("Select 3 to check your current balance.");
            System.out.println("Select 0 for Exit.");
            selection = get.nextInt();
            Account a = new Account();
            
            switch (selection) {
                case 1:
                   System.out.println("You have selected Deposits.");
                   // Exception in thread "main" java.lang.NullPointerException
                   a.deposit();
                   break;
                case 2:
                    System.out.println("You have selected Withdrawals.");
                    System.out.println("What is the amount you would like to withdraw?");
                    a.withdraw();
                    break;
                case 3:
                    a.showBalance();
                    System.out.println("Your current account balance is " + a.balance);
                    break;
                case 0:
                	a.exit();
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("You have selected an invalid option. Try again.");
                    break;
            }
        } while (!exit);
    }
}
