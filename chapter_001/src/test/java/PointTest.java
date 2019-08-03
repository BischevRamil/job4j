package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        int x1 = 1;
        int y1 = 6;
        int x2 = 5;
        int y2 = 2;
        double expected = 5.65;
        double out = Point.distance(x1,y1,x2,y2);
        double delta = 0.01;
        Assert.assertEquals(expected,out,delta);
    }
}
