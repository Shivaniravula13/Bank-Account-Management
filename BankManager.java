import java.util.ArrayList;

public class BankManager implements BankOperations {

    private ArrayList<BankAccount> accounts =
            new ArrayList<>();

    private static int accountCount = 0;

    public static final String BANK_NAME = "ABC BANK";


    // =========================
    // INNER CLASS
    // =========================

    private class Transaction {

        private String type;
        private double amount;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public void display() {
            System.out.println(
                "Transaction: " + type +
                " | Amount: ₹" + amount
            );
        }
    }


    // =========================
    // ADD ACCOUNT
    // =========================

    public void addAccount(BankAccount account) {

        accounts.add(account);
        accountCount++;

        log("Account created: "
                + account.getAccountNumber());
    }


    // =========================
    // DEPOSIT
    // =========================

    @Override
    public void deposit(String accountNumber,
                        double amount) {

        BankAccount account =
                fetchAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        account.setBalance(
                account.getBalance() + amount
        );

        log("Deposit successful: ₹" + amount);

        Transaction transaction =
                new Transaction("Deposit", amount);

        transaction.display();
    }


    // =========================
    // WITHDRAW
    // =========================

    @Override
    public void withdraw(String accountNumber, double amount)
            throws InsufficientBalanceException {

        BankAccount account =
                fetchAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > account.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance!"
            );
        }

        account.setBalance(
                account.getBalance() - amount
        );

        log("Withdrawal successful: ₹" + amount);

        Transaction transaction =
                new Transaction("Withdrawal", amount);

        transaction.display();
    }


    // =========================
    // FETCH ACCOUNT
    // =========================

    @Override
    public BankAccount fetchAccount(
            String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber()
                    .equals(accountNumber)) {

                return account;
            }
        }

        return null;
    }


    // =========================
    // TRANSFER
    // =========================

    @Override
    public void transfer(String fromAccount,
                         String toAccount,
                         double amount)
            throws InsufficientBalanceException {

        BankAccount sender =
                fetchAccount(fromAccount);

        BankAccount receiver =
                fetchAccount(toAccount);

        if (sender == null) {
            System.out.println(
                    "Sender account not found!"
            );
            return;
        }

        if (receiver == null) {
            System.out.println(
                    "Receiver account not found!"
            );
            return;
        }

        if (amount <= 0) {
            System.out.println(
                    "Invalid amount!"
            );
            return;
        }

        if (amount > sender.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance for transfer!"
            );
        }

        sender.setBalance(
                sender.getBalance() - amount
        );

        receiver.setBalance(
                receiver.getBalance() + amount
        );

        log("Transfer successful: ₹" + amount);

        Transaction transaction =
                new Transaction("Transfer", amount);

        transaction.display();
    }


    // =========================
    // DELETE ACCOUNT
    // =========================

    @Override
    public void deleteAccount(
            String accountNumber) {

        BankAccount account =
                fetchAccount(accountNumber);

        if (account != null) {

            accounts.remove(account);

            accountCount--;

            log("Deleted account: "
                    + accountNumber);

        } else {

            System.out.println(
                    "Account not found!"
            );
        }
    }


    // =========================
    // DISPLAY ACCOUNT
    // =========================

    public void displayAccount(
            String accountNumber) {

        BankAccount account =
                fetchAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found!"
            );

            return;
        }

        System.out.println(
                "\n------------------------"
        );

        System.out.println(
                "Account Number: "
                + account.getAccountNumber()
        );

        System.out.println(
                "Customer: "
                + account.getCustomer().getName()
        );

        System.out.println(
                "Account Type: "
                + account.getAccountType()
        );

        System.out.println(
                "Balance: ₹"
                + account.getBalance()
        );

        System.out.println(
                "Interest: ₹"
                + account.calculateInterest()
        );

        System.out.println(
                "------------------------"
        );
    }


    // =========================
    // STATIC METHOD
    // =========================

    public static int getAccountCount() {

        return accountCount;
    }
}