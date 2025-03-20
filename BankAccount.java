public class BankAccount {
    private double balance;
    private final Object lock = new Object();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is depositing " + amount);
            balance += amount;
            System.out.println("New balance after deposit: " + balance);
        }
    }

    public void withdraw(double amount) {
        synchronized (lock) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println("New balance after withdrawal: " + balance);
            } else {
                System.out.println("Insufficient funds!");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Create two threads for concurrent deposits
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Depositor-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(150);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Withdrawer-1");

        t1.start();
        t2.start();
    }
}