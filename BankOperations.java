interface BankOperations {

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount)
            throws InsufficientBalanceException;

    void transfer(String fromAccount, String toAccount, double amount)
            throws InsufficientBalanceException;

    BankAccount fetchAccount(String accountNumber);

    void deleteAccount(String accountNumber);

    default void log(String message) {
        System.out.println("LOG: " + message);
    }
}