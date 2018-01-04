package nl.bos.projecteuler;

import java.util.stream.IntStream;

/**
 * Created by bosa on 28-11-2017.
 */
public class MultiplesOf3And5 {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 1000)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum());
    }
}