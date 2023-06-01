package nl.bos.coding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//2, 3, 5, 7, 11, 13, 17
class PrimeNumberTest {

    @Test
    void doTrueTests() {
        assertThat(PrimeNumber.run(2)).isTrue();
        assertThat(PrimeNumber.run(3)).isTrue();
        assertThat(PrimeNumber.run(5)).isTrue();
        assertThat(PrimeNumber.run(7)).isTrue();
        assertThat(PrimeNumber.run(11)).isTrue();
        assertThat(PrimeNumber.run(13)).isTrue();
        assertThat(PrimeNumber.run(17)).isTrue();
        assertThat(PrimeNumber.run(61)).isTrue();
        assertThat(PrimeNumber.run(127)).isTrue();
        assertThat(PrimeNumber.run(199)).isTrue();
    }

    @Test
    void doFalseTests() {
        assertThat(PrimeNumber.run(-1)).isFalse();
        assertThat(PrimeNumber.run(1)).isFalse();
        assertThat(PrimeNumber.run(4)).isFalse();
        assertThat(PrimeNumber.run(6)).isFalse();
        assertThat(PrimeNumber.run(8)).isFalse();
        assertThat(PrimeNumber.run(9)).isFalse();
        assertThat(PrimeNumber.run(10)).isFalse();
        assertThat(PrimeNumber.run(12)).isFalse();
        assertThat(PrimeNumber.run(14)).isFalse();
        assertThat(PrimeNumber.run(15)).isFalse();
        assertThat(PrimeNumber.run(16)).isFalse();
        assertThat(PrimeNumber.run(60)).isFalse();
        assertThat(PrimeNumber.run(133)).isFalse();
        assertThat(PrimeNumber.run(195)).isFalse();
    }

}