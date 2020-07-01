package multithreading.threads;

/**
 * @author Bischev Ramil
 * @since 2020-06-30
 * Есть две нити. Нужно, чтобы сначала нить А печатала на консоль текст, а потом нить В.
 * Нить А всегда печатает первой.
 */
public class Switcher {
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier masterSlaveBarrier = new MasterSlaveBarrier();
        Thread first = new Thread(
                () -> {
                    while (true) {
                        masterSlaveBarrier.tryMaster();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        masterSlaveBarrier.doneMaster();
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    while (true) {
                        masterSlaveBarrier.trySlave();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        masterSlaveBarrier.doneSlave();
                    }
                }
        );
        first.start();
        second.start();
        first.join();
        second.join();
    }

    private static class MasterSlaveBarrier {
        private Boolean isMaster = true;

        public synchronized void tryMaster() {
            while (!isMaster) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread A");
        }

        public synchronized void trySlave() {
            while (isMaster) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread B");
        }

        public synchronized void doneMaster() {
            isMaster = false;
            notify();
        }

        public synchronized void doneSlave() {
            isMaster = true;
            notify();
        }
    }
}
