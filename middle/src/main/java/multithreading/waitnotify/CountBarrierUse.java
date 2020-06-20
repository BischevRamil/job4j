package multithreading.waitnotify;

public class CountBarrierUse {

    public static void main(String[] args) {
        CountBarrier countBarrier = new CountBarrier(100);

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
                countBarrier.count();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            countBarrier.await();
            System.out.println(Thread.currentThread().getName() + " started");

        });

        thread1.start();
        thread2.start();
    }
}
