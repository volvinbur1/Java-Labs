import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    void addAccount(int id, int balance) {
        accounts.add(new Account(id, balance));
    }

    int countAccounts() {
        return accounts.size();
    }

    Account getAccount(int at) {
        return accounts.get(at);
    }

    int calculateBankDeposits() {
        int totalAmount = 0;
        for (Account account : accounts) {
            totalAmount += account.getBalance();
        }
        return totalAmount;
    }

    void transfer(Account from, Account to, int amount) {
        if (from.getId() < to.getId()) {
            synchronized (from) {
                synchronized (to) {
                    if (from.withdraw(amount))
                        to.deposit(amount);
                }
            }
        }
        else if (from.getId() > to.getId()) {
            synchronized (to) {
                synchronized (from) {
                    if (from.withdraw(amount))
                        to.deposit(amount);
                }
            }
        }
    }
}
