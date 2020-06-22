package multithreading.pool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Bischev Ramil
 * @since 2020-06-22
 * The class emulates the operation of the mail delivery service with use ExecutorService.
 */
public class EmailNotification {
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public void emailTo(User user) {
        pool.execute(new Postman(user));
    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void send(String subject, String body) {
        System.out.println(subject);
        System.out.println(body);
    }

    private class Postman implements Runnable {
        private String name;
        private String email;

        public Postman(User user) {
            this.name = user.getName();
            this.email = user.getEmail();
        }

        @Override
        public void run() {
            String subject = "Notification " + this.name + " to email " + this.email;
            String body = "Add a new event to" + this.name;
            send(subject, body);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
