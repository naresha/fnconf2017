package demo;

import io.vavr.collection.List;

import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);
        numbers.forEach(System.out::println);

    }
}
