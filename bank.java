import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNumber, String accType) {
        customerName = name;
        accountNumber = accNumber;
        accountType = accType;
        balance = 0;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". Updated balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    void withdraw(double amount) {
        System.out.println("This operation is specific to account type.");
    }
}

class SavAccount extends Account {
    double interestRate = 0.04;  // 4% annual interest rate

    SavAccount(String name, int accNumber) {
        super(name, accNumber, "Savings");
    }

    void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest + ". Updated balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAccount extends Account {
    private static final double MIN_BALANCE = 500.0;
    private static final double SERVICE_CHARGE = 50.0;

    CurAccount(String name, int accNumber) {
        super(name, accNumber, "Current");
    }

    void checkMinBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum. Service charge imposed: " + SERVICE_CHARGE + ". Updated balance: " + balance);
        }
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
            checkMinBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        // Get customer details for savings account
        System.out.println("Enter customer name:");
        String name = sc.nextLine();
        System.out.println("Enter account number:");
        int accountNumber = sc.nextInt();
        SavAccount savingsAccount = new SavAccount(name, accountNumber);
       
        // Clear buffer
        sc.nextLine();
       
        // Get customer details for current account
        System.out.println("Enter customer name:");
        String name1 = sc.nextLine();
        System.out.println("Enter account number:");
        int accountNumber1 = sc.nextInt();
        CurAccount currentAccount = new CurAccount(name1, accountNumber1);

        while (true) {
            System.out.println("\n-----MENU-----");
            System.out.println("1. Deposit\n2. Withdraw\n3. Compute Interest for Savings Account\n4. Display Account Details\n5. Exit");
            System.out.print("Enter your choice: ");
           
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear the invalid input
                continue;
            }

            System.out.print("Enter the type of account (saving/current): ");
            String accType = sc.next();

            if (accType.equalsIgnoreCase("saving")) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter the deposit amount: ");
                        savingsAccount.deposit(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: ");
                        savingsAccount.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        savingsAccount.computeInterest();
                        break;
                    case 4:
                        System.out.println("Customer name: " + savingsAccount.customerName);
                        System.out.println("Account number: " + savingsAccount.accountNumber);
                        System.out.println("Type of Account: " + savingsAccount.accountType);
                        savingsAccount.displayBalance();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you for using our service!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else if (accType.equalsIgnoreCase("current")) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter the deposit amount: ");
                        currentAccount.deposit(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: ");
                        currentAccount.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        System.out.println("Current accounts do not earn interest.");
                        break;
                    case 4:
                        System.out.println("Customer name: " + currentAccount.customerName);
                        System.out.println("Account number: " + currentAccount.accountNumber);
                        System.out.println("Type of Account: " + currentAccount.accountType);
                        currentAccount.displayBalance();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you for using our service!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Invalid account type.");
            }
        }
    }
}
