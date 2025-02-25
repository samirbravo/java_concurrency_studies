package CH03_Mutual_Exclusion.SynchronizedMethod;

/**
 * Two shoppers adding items to a shared notepad
 */

class Shopper extends Thread {

    static int garlicCount = 0;

    private static synchronized void addGarlic() {
        garlicCount++;
    } //if it is not static, each thread will have its own method

    public void run() {
        for (int i=0; i<10_000_000; i++)
            addGarlic(); // call synchronized method
    }
}

public class SynchronizedMethodDemo {
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