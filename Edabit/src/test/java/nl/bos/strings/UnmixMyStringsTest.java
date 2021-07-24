package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmixMyStringsTest {
    @Test
    public void test1() {
        assertEquals("214365", UnmixMyStrings.unmix("123456"));
    }

    @Test
    public void test2() {
        assertEquals("This is a mixed up string.", UnmixMyStrings.unmix("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    public void test3() {
        assertEquals("abcde", UnmixMyStrings.unmix("badce"));
    }

    @Test
    public void test4() {
        assertEquals("I am feeling a little dizzy!", UnmixMyStrings.unmix(" Imaf eeilgna l tilt eidzz!y"));
    }

    @Test
    public void test5() {
        System.out.println("Should work with empty strings as well.");
        assertEquals("", UnmixMyStrings.unmix(""));
    }
}