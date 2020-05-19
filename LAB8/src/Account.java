public class Account {
    private int id;
    private int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }


    int getBalance() {
        return balance;
    }

    int getId() {
        return id;
    }

    boolean withdraw(int amount) {
        if (amount <= 0)
            return false;
        if (balance - amount < 0)
            return false;
        balance -= amount;
        return true;
    }

    void deposit(int amount) {
        if (amount <= 0)
            return;
        balance += amount;
    }
}
