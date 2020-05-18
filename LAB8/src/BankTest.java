import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class BankTest {

    @org.junit.Test
    public void assetsTransfer() {
        Random random = new Random();
        Bank bank = new Bank();
        for (int i = 0; i < 189; i ++)
            bank.addAccount(i, random.nextInt(2548));

        int expectedTotalBankDeposit = bank.calculateBankDeposits();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 6543; i++) {
            int form_id = random.nextInt(bank.countAccounts());
            int to_id = random.nextInt(bank.countAccounts());
            int amount = random.nextInt(356);
            threads.add(new Thread(() -> bank.transfer(bank.getAccount(form_id), bank.getAccount(to_id), amount)));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            if (thread.isAlive()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        assertEquals(expectedTotalBankDeposit, bank.calculateBankDeposits());
    }

    @org.junit.Test
    public void balanceCalculation() {
        Random random = new Random();
        Bank bank = new Bank();
        int expectedBalance = 0;
        for (int i = 0; i < 123; i ++) {
            int balanceValue = random.nextInt(2548);
            bank.addAccount(i, balanceValue);
            expectedBalance += balanceValue;
        }
        assertEquals(expectedBalance, bank.calculateBankDeposits());
    }
}