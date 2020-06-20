package multithreading.nonblockingcache;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NBACacheTest {

    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new OptimisticException("Data can't be changed.");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        assertThat(ex.get().getMessage(), is("Data can't be changed."));
    }

    @Test
    public void whenTryChangeOneModel() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        class ThreadForNBCache implements Runnable {
            private NBACache cache;

            public ThreadForNBCache(NBACache cache) {
                this.cache = cache;
            }

            @Override
            public void run() {
                try {
                    this.cache.update(new Base(1, "name2"));
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        }
        NBACache nCache = new NBACache();
        nCache.add(new Base(1, "name1"));
        Thread thread1 = new Thread(new ThreadForNBCache(nCache));
        Thread thread2 = new Thread(new ThreadForNBCache(nCache));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(ex.get().getMessage(), is("Data can't be changed."));
    }
}
