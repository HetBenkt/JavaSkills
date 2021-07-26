package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfDuplicateCharsTest {
    @Test
    public void test1() {
        assertEquals(0, CountNumberOfDuplicateChars.duplicateCount("abcde"));
    }

    @Test
    public void test2() {
        System.out.println("Duplicate characters are case sensitive.");
        assertEquals(0, CountNumberOfDuplicateChars.duplicateCount("Aa"));
    }

    @Test
    public void test3() {
        assertEquals(2, CountNumberOfDuplicateChars.duplicateCount("aabbcde"));
    }

    @Test
    public void test4() {
        assertEquals(2, CountNumberOfDuplicateChars.duplicateCount("aabbcdeB"));
    }

    @Test
    public void test5() {
        assertEquals(1, CountNumberOfDuplicateChars.duplicateCount("indivisibility"));
    }

    @Test
    public void test6() {
        assertEquals(2, CountNumberOfDuplicateChars.duplicateCount("Indivisibilities"));
    }

    @Test
    public void test7() {
        assertEquals(2, CountNumberOfDuplicateChars.duplicateCount("aa1112"));
    }

    @Test
    public void test8() {
        assertEquals(1, CountNumberOfDuplicateChars.duplicateCount("bb2c"));
    }
}