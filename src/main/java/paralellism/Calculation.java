package paralellism;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculation {
    public static void main(String[] args) {

        long count = Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .parallel()   //with this 23s, without this 1m 10s
                .filter(Calculation::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }
}
