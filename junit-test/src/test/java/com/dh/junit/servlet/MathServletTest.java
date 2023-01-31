package com.dh.junit.servlet;

import org.junit.Assert;
import org.junit.Test;

public class MathServletTest {
    @Test
    public void testSum() {
        MathServlet mathServlet = new MathServlet();
        int actual = mathServlet.sum(4, 4);
        int expected = 8;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSub() {
        MathServlet mathServlet = new MathServlet();
        int actual = mathServlet.sub(20, 5);
        int expected = 15;
        Assert.assertEquals(expected, actual);
    }
}
