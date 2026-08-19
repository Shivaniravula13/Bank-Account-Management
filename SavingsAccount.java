class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, Customer customer,       double balance) {

        super(accountNumber, customer, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}