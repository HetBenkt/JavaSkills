package nl.bos.coding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    @Test
    void doTrueTests() {
        assertThat(Palindrome.run("Bob")).isTrue();
        assertThat(Palindrome.run("lepel")).isTrue();
        assertThat(Palindrome.run("1234554321")).isTrue();
    }

    @Test
    void doFalseTests() {
        assertThat(Palindrome.run("Bop")).isFalse();
        assertThat(Palindrome.run("regel")).isFalse();
        assertThat(Palindrome.run("1234564321")).isFalse();
    }

}