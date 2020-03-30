package nl.bos.kyu7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VowelsTest {

    @Test
    public void testCase1() {
        assertEquals("Nope!", 5, Vowels.getCount("abracadabra"));
        assertEquals("Nope!", 10, Vowels.getCount("abracadabraabracadabra"));
        assertEquals("Nope!", 15, Vowels.getCount("aeiouaeiouaeiou"));
    }
}