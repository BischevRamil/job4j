package collections.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {

    @Test
    public void diffTest() {
        Analize analize = new Analize();
        List<Analize.User> list1 = new ArrayList<>();
        List<Analize.User> list2 = new ArrayList<>();

        list1.add(new Analize.User(1, "one"));
        list1.add(new Analize.User(2, "two"));
        list1.add(new Analize.User(3, "three"));
        list1.add(new Analize.User(4, "four"));
        list1.add(new Analize.User(5, "five"));
        list1.add(new Analize.User(6, "six"));

        list2.add(new Analize.User(1, "one"));
        list2.add(new Analize.User(3, "threethree"));
        list2.add(new Analize.User(4, "fourfour"));
        list2.add(new Analize.User(5, "five"));
        list2.add(new Analize.User(7, "seven"));

        assertThat(analize.diff(list1, list2).getChanged(), is(2));
        assertThat(analize.diff(list1, list2).getAdded(), is(1));
        assertThat(analize.diff(list1, list2).getDeleted(), is(2));
    }
}
