package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest
{
    @Test
    public void test()
    {
        Main main = new Main();
        int a = 5;
        int b = 7;

        assertEquals(a+b,main.add(a,b));
    }

    @Test
    public void testTwo()
    {
        Main main = new Main();
        int a = 1;
        int v = 3;

        assertEquals(a+v,main.add(a,v));
    }

    @Test
    public void testThree()
    {
        Main main = new Main();
        assertNull("Should be not NULL",main.add(1,1));
    }
}