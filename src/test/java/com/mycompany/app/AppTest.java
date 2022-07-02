package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    public void twoAndThreeIsFive() throws Exception {
        final long result = new App().add(2, 3);
        assertThat(result, is(5L));
    }

    @Test
    public void twoAndZeroIsTwo() throws Exception {
        final long result = new App().add(2, 0);
        assertThat(result, is(2L));
    }

    @Test
    public void twoAndMinusTwoIsZero() throws Exception {
        final long result = new App().add(2, -2);
        assertThat(result, is(0L));
    }

    @Test
    public void threeMinusTwoIsOne() throws Exception {
        final long result = new App().subtract(3, 2);
        assertThat(result, is(1L));
    }

    @Test
    public void threeMinusThreeIsZero() throws Exception {
        final long result = new App().subtract(3, 3);
        assertThat(result, is(0L));
    }

    @Test
    public void threeMinusMinusThreeIsSix() throws Exception {
        final long result = new App().subtract(3, -3);
        assertThat(result, is(6L));
    }

    @Test
    public void threeXThreeIsNine() throws Exception {
        final long result = new App().multiply(3, 3);
        assertThat(result, is(9L));
    }

    @Test
    public void threeXZeroIsZero() throws Exception {
        final long result = new App().multiply(3, 0);
        assertThat(result, is(0L));
    }

    @Test
    public void threeXMinusThreeIsMinusNine() throws Exception {
        final long result = new App().multiply(3, -3);
        assertThat(result, is(-9L));
    }
    
    @Test
    public void sixDividedThreeIsTwo() throws Exception {
        final long result = new App().divide(6, 3);
        assertThat(result, is(2L));
    }

}
