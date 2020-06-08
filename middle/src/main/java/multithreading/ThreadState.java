package multithreading;

/**
 * @author Bischev Ramil
 * @since 2020-06-07
 * Each thread print his name. Then main thread print state.
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> System.out.println("First thread")
        );
        Thread second = new Thread(
                () -> System.out.println("Second thread")
        );
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            System.out.println("First thread state is " + first.getState());
            System.out.println("Second thread state is " + second.getState());
            System.out.println("wait");
        }
        System.out.println("First thread state is " + first.getState());
        System.out.println("Second thread state is " + second.getState());
        System.out.println("Threads is terminated");
    }
}
