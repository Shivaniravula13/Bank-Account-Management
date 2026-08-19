class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber,Customer customer,
                double balance) {

        super(accountNumber, customer, balance);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }
}