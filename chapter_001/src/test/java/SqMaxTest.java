package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenMax1(){
        SqMax sqMax = new SqMax();
        int result = sqMax.sqMax(7,2,5,1);
        assertThat(result, is(7));

    }

    @Test
    public void whenMax2(){
        SqMax sqMax = new SqMax();
        int result = sqMax.sqMax(7,9,5,1);
        assertThat(result, is(9));

    }
    @Test
    public void whenMax3(){
        SqMax sqMax = new SqMax();
        int result = sqMax.sqMax(7,2,9,1);
        assertThat(result, is(9));

    }
    @Test
    public void whenMax4(){
        SqMax sqMax = new SqMax();
        int result = sqMax.sqMax(7,2,5,9);
        assertThat(result, is(9));

    }
}
