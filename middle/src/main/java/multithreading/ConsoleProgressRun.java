package multithreading;

/**
 * @author Bischev Ramil
 * @since 2020-06-07
 * Interrupt the thread.
 */
class ConsoleProgress implements Runnable {
    @Override
    public void run() {
        var i = 0;
        String s = "";
        while (!Thread.currentThread().isInterrupted()) {
            i++;
            switch (i % 3) {
                case 0: s = "\\";
                break;
                case 1: s = "|";
                break;
                case 2: s = "/";
                break;
                default: break;
            }

            System.out.print("\r load: " + s);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ConsoleProgressRun {
    public static void main(String[] args) {
        Thread run = new Thread(new ConsoleProgress());
        run.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        run.interrupt();
    }
}
