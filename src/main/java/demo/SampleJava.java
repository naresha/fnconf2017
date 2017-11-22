package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleJava {
    public static void main(String[] args) {
        Predicate<Integer> even = number -> number % 2 == 0;
        Function<Integer, Integer> doubler = number -> number + number;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);



        Stream.of(Optional.of(1), Optional.of(2), Optional.empty())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

    }
}
