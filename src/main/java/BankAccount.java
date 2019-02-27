

public class BankAccount {
    private String firstname;
    private String lastname;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstname, String lastname, double balance, int accountType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
        this.accountType = accountType;
    }

    // jesli klient wykonuje transakcje w oddziale z kasjerem, to branch = true;
    // jesli klient wykonuje transakcję przez internet, branch = false;
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) throws IllegalAccessException {
        if(amount > 500.00 && !branch) {
            throw new IllegalAccessException();
        }

        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }
}
