package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeStringTest {

    @Test
    public void isPalindromeTest() {
        //given
        String input = "level";
        //when
        boolean isCorrect = PalindromeString.isPalindrome(input);
        //then
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void isNotPalindromeTest() {
        //given
        String input = "helloworld";
        //when
        boolean isCorrect = PalindromeString.isPalindrome(input);
        //then
        Assert.assertFalse(isCorrect);
    }
}