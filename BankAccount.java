abstract class BankAccount {

    private String accountNumber;
    private Customer customer;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber,   Customer customer,
    double balance) {

        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods to be overridden
    public abstract double calculateInterest();

    public abstract String getAccountType();
}