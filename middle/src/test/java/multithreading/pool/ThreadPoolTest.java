package multithreading.pool;

import org.junit.Test;

public class ThreadPoolTest {

    @Test
    public void test() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.work(new Thread(new Tasks()));
        }
        threadPool.shutdown();
        assert true;
    }

    private static class Tasks implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
