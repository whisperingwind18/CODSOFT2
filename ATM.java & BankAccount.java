import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        account.deposit(amount);
        System.out.println("Successfully deposited: $" + amount);
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ATM atm = new ATM(account);
        atm.start();
    }
}




BANKACCOUNT.JAVA:-

  public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0; // Initial balance
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}

