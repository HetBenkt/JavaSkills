package nl.bos.coding;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

//https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
//0 1 1 2 3 5 8 13 21 34 55 89 144
class FibonacciTest {
    @Test
    void do0Test() {
        String expected = "0";
        assertThat(Fibonacci.run(0)).isEqualTo(expected);
    }

    @Test
    void do1Test() {
        String expected = "0 1 1";
        assertThat(Fibonacci.run(1)).isEqualTo(expected);
    }

    @Test
    void do2Test() {
        String expected = "0 1 1 2";
        assertThat(Fibonacci.run(2)).isEqualTo(expected);
    }

    @Test
    void do3Test() {
        String expected = "0 1 1 2 3";
        assertThat(Fibonacci.run(3)).isEqualTo(expected);
    }

    @Test
    void do4Test() {
        String expected = "0 1 1 2 3";
        assertThat(Fibonacci.run(4)).isEqualTo(expected);
    }

    @Test
    void do5Test() {
        String expected = "0 1 1 2 3 5";
        assertThat(Fibonacci.run(5)).isEqualTo(expected);
    }

    @Test
    void do6Test() {
        String expected = "0 1 1 2 3 5";
        assertThat(Fibonacci.run(6)).isEqualTo(expected);
    }

    @Test
    void do21Test() {
        String expected = "0 1 1 2 3 5 8 13 21";
        assertThat(Fibonacci.run(21)).isEqualTo(expected);
    }

    @Test
    void do144Test() {
        String expected = "0 1 1 2 3 5 8 13 21 34 55 89 144";
        assertThat(Fibonacci.run(144)).isEqualTo(expected);
    }

    @Test
    void do146Test() {
        String expected = "0 1 1 2 3 5 8 13 21 34 55 89 144";
        assertThat(Fibonacci.run(146)).isEqualTo(expected);
    }

}