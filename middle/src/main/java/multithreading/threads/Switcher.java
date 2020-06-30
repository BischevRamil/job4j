package multithreading.threads;

/**
 * @author Bischev Ramil
 * @since 2020-06-30
 * Есть две нити. Нужно, чтобы сначала нить А печатала на консоль текст, а потом нить В.
 * Нить А всегда печатает первой.
 */
public class Switcher {
    private volatile boolean aBoolean = true;

    public static void main(String[] args) throws InterruptedException {
        new Switcher().startSwitcher();
    }

    private void startSwitcher() throws InterruptedException {
        Thread first = new Thread(new A());
        Thread second = new Thread(new B());
        first.start();
        second.start();
        first.join();
        second.join();
    }

    private synchronized void printA() {
        while (!aBoolean) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aBoolean = false;
        notify();
    }

    private synchronized void printB() {
        while (aBoolean) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread B");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aBoolean = true;
        notify();
    }

    private class A implements Runnable {
        @Override
        public void run() {
            while (true) {
                printA();
            }
        }
    }

    private class B implements Runnable {
        @Override
        public void run() {
            while (true) {
                printB();
            }
        }
    }
}
