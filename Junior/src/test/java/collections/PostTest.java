package collections;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostTest {
    private Map<String, HashSet<String>> resultMap;
    private final String e1 = "xxx@ya.ru";
    private final String e2 = "foo@gmail.com";
    private final String e3 = "lol@mail.ru";
    private final String e4 = "ups@pisem.net";
    private final String e5 = "xyz@pisem.net";
    private final String e6 = "vasya@pupkin.com";
    private final String e7 = "aaa@bbb.ru";

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

    @Test
    public void postTest1() {
        Post post = new Post();
        this.resultMap = new HashMap<>();
        post.add("user1", new HashSet<>(Set.of(e1, e2, e3)));
        post.add("user2", new HashSet<>(Set.of(e2, e4)));
        post.add("user3", new HashSet<>(Set.of(e5, e6)));
        post.add("user4", new HashSet<>(Set.of(e4, e7)));
        post.add("user5", new HashSet<>(Set.of(e5)));

        this.resultMap.put("user1", new HashSet<>(Set.of(e1, e2, e3, e4, e7)));
        this.resultMap.put("user5", new HashSet<>(Set.of(e5, e6)));
        assertThat(post.run(), is(this.resultMap));
    }

    @Test
    public void postTest2() {
        Post post = new Post();
        this.resultMap = new HashMap<>();
        post.add("user1", new HashSet<>(Set.of(e1)));
        post.add("user2", new HashSet<>(Set.of(e2)));
        post.add("user3", new HashSet<>(Set.of(e3)));
        post.add("user4", new HashSet<>(Set.of(e4)));
        post.add("user5", new HashSet<>(Set.of(e5)));

        this.resultMap.put("user1", new HashSet<>(Set.of(e1)));
        this.resultMap.put("user2", new HashSet<>(Set.of(e2)));
        this.resultMap.put("user3", new HashSet<>(Set.of(e3)));
        this.resultMap.put("user4", new HashSet<>(Set.of(e4)));
        this.resultMap.put("user5", new HashSet<>(Set.of(e5)));
        assertThat(post.run(), is(this.resultMap));
    }

    @Test
    public void postTest3() {
        Post post = new Post();
        this.resultMap = new HashMap<>();
        post.add("user1", new HashSet<>(Set.of(e1)));
        post.add("user2", new HashSet<>(Set.of(e1, e2)));
        post.add("user3", new HashSet<>(Set.of(e1, e2, e3)));
        post.add("user4", new HashSet<>(Set.of(e1, e2, e3, e4)));
        post.add("user5", new HashSet<>(Set.of(e1, e2, e3, e4, e5)));

        this.resultMap.put("user1", new HashSet<>(Set.of(e1, e2, e3, e4, e5)));
        assertThat(post.run(), is(this.resultMap));
    }
}
