package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostTest {
    Post post = new Post();
    private Map<String, HashSet<String>> resultMap = new HashMap<>();

    /**
     * На входе:
     * user1 -> xxx@ya.ru,foo@gmail.com,lol@mail.ru
     * user2 -> foo@gmail.com,ups@pisem.net
     * user3 -> xyz@pisem.net,vasya@pupkin.com
     * user4 -> ups@pisem.net,aaa@bbb.ru
     * user5 -> xyz@pisem.net
     *
     * На выходе:
     * user1 -> xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
     * user5 -> xyz@pisem.net,vasya@pupkin.com
     */
    @Before
    public void init() {
        String e1 = "xxx@ya.ru";
        String e2 = "foo@gmail.com";
        String e3 = "lol@mail.ru";
        String e4 = "ups@pisem.net";
        String e5 = "xyz@pisem.net";
        String e6 = "vasya@pupkin.com";
        String e7 = "aaa@bbb.ru";

        this.post.add("user1", new HashSet<>(Set.of(e1, e2, e3)));
        this.post.add("user2", new HashSet<>(Set.of(e2, e4)));
        this.post.add("user3", new HashSet<>(Set.of(e5, e6)));
        this.post.add("user4", new HashSet<>(Set.of(e4, e7)));
        this.post.add("user5", new HashSet<>(Set.of(e5)));

        this.resultMap.put("user1", new HashSet<>(Set.of(e1, e2, e3, e4, e7)));
        this.resultMap.put("user5", new HashSet<>(Set.of(e5, e6)));
    }

    @Test
    public void postTest() {
        assertThat(this.post.run(), is(this.resultMap));
    }
}
