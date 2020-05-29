package gc.softreference;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CacheTest {
    private static final String LS = System.lineSeparator();
    private String path = "src/main/resources/cache/";

    @Test
    public void whenPutNewKeyThenFileCaches() {
        Cache cache = new Cache(path);
        cache.put("name.txt");
        StringBuilder expected = new StringBuilder()
                .append("Ivan")
                .append(LS)
                .append("Maria");
        assertThat(cache.getText("name.txt"), is(expected.toString()));
    }

    @Test
    public void whenGetEmptyKeyThenReturnValue() {
        Cache cache = new Cache(path);
        StringBuilder expected = new StringBuilder()
                .append("ivan@mail.com")
                .append(LS)
                .append("maria@mail.com");
        assertThat(cache.getText("adress.txt"), is(expected.toString()));
    }
}
