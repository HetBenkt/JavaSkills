package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtractWordFromSentenceTest {
    @Test
    public void test1() {
        assertEquals("The quick brown jumped over the lazy dog",
                ExtractWordFromSentence.removeWord("The quick brown fox jumped over the lazy dog", "fox")
        );
    }

    @Test
    public void test2() {
        assertEquals("The cow over the moon",
                ExtractWordFromSentence.removeWord("The cow jumped over the moon", "jumped")
        );
    }

    @Test
    public void test3() {
        assertEquals("Sally sells seashells by seashore",
                ExtractWordFromSentence.removeWord("Sally sells seashells by the seashore", "the")
        );
    }

    @Test
    public void test4() {
        assertEquals("I like to walk on ",
                ExtractWordFromSentence.removeWord("I like to walk on Sundays", "Sundays")
        );
    }
}