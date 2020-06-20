package multithreading.nonblockingcache;

public class OptimisticException extends RuntimeException {
    OptimisticException(String message) {
        super(message);
    }
}
