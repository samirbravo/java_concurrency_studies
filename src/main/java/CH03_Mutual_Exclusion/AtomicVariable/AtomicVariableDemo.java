package CH03_Mutual_Exclusion.AtomicVariable;

/**
 * Two shoppers adding items to a shared notepad
 */

import java.util.concurrent.atomic.*;

class Shopper extends Thread {

    static AtomicInteger garlicCount = new AtomicInteger(0);

    public void run() {
        for (int i=0; i<10_000_000; i++)
            garlicCount.incrementAndGet();
    }
}

public class AtomicVariableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper();
        Thread olivia = new Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");
    }
}