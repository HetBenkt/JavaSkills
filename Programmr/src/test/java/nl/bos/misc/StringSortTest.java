package nl.bos.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringSortTest {

    @Test
    public void sort1Test() {
        //given
        String input = "helloworld";
        String expected = "dehllloorw";
        //when
        String actual = StringSort.sort(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sort2Test() {
        //given
        String input = "PROGRAMR";
        String expected = "AGMOPRRR";
        //when
        String actual = StringSort.sort(input);
        //then
        assertEquals(expected, actual);
    }
}