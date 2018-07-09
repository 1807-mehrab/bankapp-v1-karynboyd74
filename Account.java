public class Account {
    private double balance = 0;
    private double amount;

    public Account(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    // methods that all accounts will have in common
    private void deposit(double amount) {
        // to be determined
    }

    private void withdraw(double amount) {
        // to be determined
    }

    public double getBalance()
    {
        return balance;
    }

    public setBalance(double balance) {
        this.balance = balance;
    }
}