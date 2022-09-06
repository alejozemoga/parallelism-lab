package paralellism;

import java.util.stream.IntStream;

public class BaseStreamExample {

    public static void main(String[] args) {

        System.out.println("Normal...");

        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.forEach(System.out::println);

        System.out.println("Parallel...");

        IntStream intStream2 = IntStream.rangeClosed(1, 10);
        intStream2.parallel().forEach(System.out::println);
    }
}
