package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalCapitalChallengeTest {
    @Test
    public void test1() {
        assertEquals("help", CapitalChallenge.selectLetters("heLLO", "GUlp"));
    }

    @Test
    public void test2() {
        assertEquals("135", CapitalChallenge.selectLetters("1234567", "XxXxX"));
    }

    @Test
    public void test3() {
        assertEquals("EYSomeThings", CapitalChallenge.selectLetters("EVERYTHING", "SomeThings"));
    }

    @Test
    public void test4() {
        assertEquals("atrpten", CapitalChallenge.selectLetters("PaTtErN", "pAtTeRn"));
    }

    @Test
    public void test5() {
        assertEquals("", CapitalChallenge.selectLetters("nothing", "nothing"));
    }

    @Test
    public void test6() {
        assertEquals("What doR", CapitalChallenge.selectLetters("What do you think of it so far?", "RUBBISH!"));
    }
}