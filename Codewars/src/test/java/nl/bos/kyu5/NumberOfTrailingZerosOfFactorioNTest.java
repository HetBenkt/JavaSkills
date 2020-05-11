package nl.bos.kyu5;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberOfTrailingZerosOfFactorioNTest {
    @Test
    public void testZeros() {
        //https://www.youtube.com/watch?v=wdz_KouqHx4
        assertThat(NumberOfTrailingZerosOfFactorioN.zeros(0), is(0));
        assertThat(NumberOfTrailingZerosOfFactorioN.zeros(6), is(1));
        assertThat(NumberOfTrailingZerosOfFactorioN.zeros(14), is(2));
        assertThat(NumberOfTrailingZerosOfFactorioN.zeros(25), is(6));
        assertThat(NumberOfTrailingZerosOfFactorioN.zeros(100), is(24));
        assertThat(NumberOfTrailingZerosOfFactorioN.zeros(125), is(31));
    }
}