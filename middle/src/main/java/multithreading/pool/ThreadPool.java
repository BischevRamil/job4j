package multithreading.pool;

import multithreading.waitnotify.SimpleBlockingQueue;

/**
 * @author Bischev Ramil
 * @since 2020-06-21
 * Class implements Executor Service.
 */
public class ThreadPool {
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(10);
    private volatile boolean isRunning = true;

    public ThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            new Thread(new TaskWorker()).start();
        }
    }

    public void work(Runnable job) throws InterruptedException {
        if (isRunning) {
            tasks.offer(job);
        }
    }

    public void shutdown() {
        isRunning = false;
    }

    private final class TaskWorker implements Runnable {
        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = null;
                try {
                    nextTask = tasks.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
