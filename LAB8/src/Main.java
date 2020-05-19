import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
	    Bank bank = new Bank();
        for (int i = 0; i < 155; i ++)
	        bank.addAccount(i, random.nextInt(1000));

        System.out.println("Bank deposit before transfer: " + bank.calculateBankDeposits());

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5555; i++) {
            int form_id = random.nextInt(bank.countAccounts());
            int to_id = random.nextInt(bank.countAccounts());
            int amount = random.nextInt(500);
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

        System.out.println("Bank deposit after transfer: " + bank.calculateBankDeposits());
    }
}
