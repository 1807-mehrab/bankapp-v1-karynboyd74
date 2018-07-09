import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int selection;
        boolean exit = false;
        do {
            System.out.println("Welcome to the Bank of Boyd! Please make your selection from the following menu.");
            System.out.println("Select 1 for Deposit.");
            System.out.println("Select 2 for Withdrawal.");
            System.out.println("Select 3 to check your current balance.");
            System.out.println("Select 0 for Exit.");
            selection = get.nextInt();
            double balance = 100.00; // this would be pulled from the account object
            double amount; // this is the amount the user is entering to withdraw or deposit

            switch (selection) {
                case 1:
                   System.out.println("You have selected Deposits.");
                    System.out.println("Enter the amount you would like to deposit: ");
                    amount = get.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Invalid amount entered. Please enter a dollar amount greater than $0.00. ");
                       } else {
                           deposit(amount);
                        System.out.println("$" + amount + " has been deposited.");
                        System.out.println("Your balance is now: $" + balance);
                       }
                    break;
                case 2:
                    System.out.println("You have selected Withdrawals.");
                    System.out.println("What is the amount you would like to withdraw?");
                    amount = get.nextDouble();
                    if (amount >= 100) {
                        System.out.println("Invalid amount entered. This amount will give you a negative balance. Please try again. ");
                    } else {
                        balance = balance -= amount;
                        System.out.println("$" + amount + " has been withdrawn.");
                        System.out.println("Your balance is now: $" + balance);
                    }
                    break;
                case 3:
                    //showBalance();
                    System.out.println("TRying to get balance to work");
                    break;
                case 0:
                    System.out.println("Good bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("You have selected an invalid option. Try again.");
                    break;
            }
        } while (!exit);
    }

    public class Account {
        private double balance = 0;
    
        public Account(double balance) {
            this.balance = balance;
        }
    
       public void deposit() {
            double amount;
            System.out.println("Enter the amount to deposit: ");
            amount = get.nextDouble();
            balance = balance + amount;
            System.out.println("Deposited $" + amount + ". Your balance is $" + balance);
       }

       public void withdraw() {
           // withdraw stuff
       }

       public double showBalance() {
           return balance;
       }
    }
}