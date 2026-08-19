import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Address
        Address address = new Address("Warangal", "Telangana", "506006");

        // Create Customer
        Customer customer = new Customer(
                "Tharunya",
                21,
                "C001",
                address
        );

        // Create Accounts
        BankAccount savings = new SavingsAccount(
                "ACC101",
                customer,
                10000
        );

        BankAccount current = new CurrentAccount(
                "ACC102",
                customer,
                10000
        );

        BankAccount selectedAccount = null;

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     BANK MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Savings Account");
            System.out.println("2. View Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Calculate Interest");
            System.out.println("7. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    selectedAccount = savings;
                    displayAccount(savings);
                    break;

                case 2:
                    selectedAccount = current;
                    displayAccount(current);
                    break;

                case 3:
                    System.out.println("\nSelect Account:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Enter choice: ");

                    int depositAccount = sc.nextInt();

                    if (depositAccount == 1) {
                        selectedAccount = savings;
                    } else if (depositAccount == 2) {
                        selectedAccount = current;
                    } else {
                        System.out.println("Invalid account choice.");
                        break;
                    }

                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Amount must be greater than 0.");
                    } else {
                        selectedAccount.setBalance(
                                selectedAccount.getBalance() + deposit
                        );

                        System.out.println("Deposit successful!");
                        System.out.println(
                                "New Balance: ₹" + selectedAccount.getBalance()
                        );
                    }
                    break;

                case 4:
                    System.out.println("\nSelect Account:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Enter choice: ");

                    int withdrawAccount = sc.nextInt();

                    if (withdrawAccount == 1) {
                        selectedAccount = savings;
                    } else if (withdrawAccount == 2) {
                        selectedAccount = current;
                    } else {
                        System.out.println("Invalid account choice.");
                        break;
                    }

                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Amount must be greater than 0.");
                    } else if (withdraw > selectedAccount.getBalance()) {
                        System.out.println("Insufficient balance!");
                    } else {
                        selectedAccount.setBalance(
                                selectedAccount.getBalance() - withdraw
                        );

                        System.out.println("Withdrawal successful!");
                        System.out.println(
                                "Remaining Balance: ₹" +
                                selectedAccount.getBalance()
                        );
                    }
                    break;

                case 5:
                    System.out.println("\nSelect Account:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Enter choice: ");

                    int balanceAccount = sc.nextInt();

                    if (balanceAccount == 1) {
                        selectedAccount = savings;
                    } else if (balanceAccount == 2) {
                        selectedAccount = current;
                    } else {
                        System.out.println("Invalid account choice.");
                        break;
                    }

                    System.out.println(
                            "Account Number: " +
                            selectedAccount.getAccountNumber()
                    );

                    System.out.println(
                            "Account Type: " +
                            selectedAccount.getAccountType()
                    );

                    System.out.println(
                            "Balance: ₹" +
                            selectedAccount.getBalance()
                    );
                    break;

                case 6:
                    System.out.println("\nSelect Account:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Enter choice: ");

                    int interestAccount = sc.nextInt();

                    if (interestAccount == 1) {
                        selectedAccount = savings;
                    } else if (interestAccount == 2) {
                        selectedAccount = current;
                    } else {
                        System.out.println("Invalid account choice.");
                        break;
                    }

                    double interest =
                            selectedAccount.calculateInterest();

                    System.out.println(
                            "Account Type: " +
                            selectedAccount.getAccountType()
                    );

                    System.out.println(
                            "Interest: ₹" + interest
                    );
                    break;

                case 7:
                    System.out.println("\nThank you for using");
                    System.out.println("Bank Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }

    // Method to display account details
    public static void displayAccount(BankAccount account) {

        System.out.println("\n----- " +
                account.getAccountType().toUpperCase() +
                " -----");

        System.out.println(
                "Account Number: " +
                account.getAccountNumber()
        );

        System.out.println(
                "Customer: " +
                account.getCustomer()
        );

        System.out.println(
                "Account Type: " +
                account.getAccountType()
        );

        System.out.println(
                "Balance: ₹" +
                account.getBalance()
        );

        System.out.println(
                "Interest: ₹" +
                account.calculateInterest()
        );
    }
}