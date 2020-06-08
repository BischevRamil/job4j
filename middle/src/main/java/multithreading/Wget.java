package multithreading;

/**
 * @author Bischev Ramil
 * @since 2020-06-07
 * Class imitate load process.
 */
public class Wget {
    public static void main(String[] args) {
        Thread load = new Thread(
                () -> {
                    for (int i = 0; i <= 100; i++) {
                        System.out.print("\rLoading : " + i  + "%");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                }
        );
        load.start();
    }
}
