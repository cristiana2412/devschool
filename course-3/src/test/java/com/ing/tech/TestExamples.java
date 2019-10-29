package com.ing.tech;


import org.junit.Assert;
import org.junit.Test;

public class TestExamples {

    @Test
    public void shouldHaveTheSameName() {
        String expected = "example";
        String actual = "example";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveADifferentName() {
        String expected = "example";
        String actual = "example1";

        Assert.assertNotEquals(expected, actual);
    }


}
