import java.util.Scanner;

class Account {
    String CustomerName;
    int accountnumber;
    String accounttype;
    double balance;

    Account(String name, int accno, String acctype, double bal) {
        CustomerName = name;
        accountnumber = accno;
        accounttype = acctype;
        balance = bal;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void displaybal() {
        System.out.println("Account holder name: " + CustomerName);
        System.out.println("Account number: " + accountnumber);
        System.out.println("Account type: " + accounttype);
        System.out.println("Current balance (in rupees): " + balance);
    }

    public void withdraw(double amount) {
        // overridden in subclasses
    }
}

// ---------------- Savings Account ----------------
class Savacct extends Account {
    private static double interest_rate = 0.05;

    Savacct(String name, int accno, double bal) {
        super(name, accno, "Savings", bal);
    }

    public void computeanddeposit(int years) {
        double interest = balance * Math.pow(1 + interest_rate, years) - balance;
        balance += interest;
        System.out.println("Interest of rupees " + interest +
                " added for " + years + " years.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of rupees " + amount + " successful!");
        }
    }
}

// ---------------- Current Account ----------------
class Curracct extends Account {
    private static final double min_bal = 10000;
    private static final double service_charge = 100;

    Curracct(String name, int accno, double bal) {
        super(name, accno, "Current", bal);
    }

    private void checkminbal() {
        if (balance < min_bal) {
            balance -= service_charge;
            System.out.println(
                "Balance below minimum! Service charge of rupees "
                + service_charge + " imposed!"
            );
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of rupees " + amount + " successful!");
            checkminbal();
        }
    }
}

// ---------------- Main Class ----------------
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-- WELCOME TO BANK SYSTEM --");

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accno = sc.nextInt();

        System.out.println("Enter account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int type = sc.nextInt();

        System.out.print("Enter initial deposit (in rupees): ");
        double bal = sc.nextDouble();

        Account acc;
        if (type == 1) {
            acc = new Savacct(name, accno, bal);
        } else {
            acc = new Curracct(name, accno, bal);
        }

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (acc instanceof Savacct) {
                System.out.println("4. Compute and Deposit Interest");
            }
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit (in rupees): ");
                    acc.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw (in rupees): ");
                    acc.withdraw(sc.nextDouble());
                    break;

                case 3:
                    acc.displaybal();
                    break;

                case 4:
                    if (acc instanceof Savacct) {
                        System.out.print("Enter number of years: ");
                        int years = sc.nextInt();
                        ((Savacct) acc).computeanddeposit(years);
                    } else {
                        System.out.println(
                            "Interest calculation not applicable for current account."
                        );
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the bank system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
