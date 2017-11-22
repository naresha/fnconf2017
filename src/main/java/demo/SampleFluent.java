package demo;

import io.vavr.Function1;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.function.Function;
import java.util.function.Predicate;

public class SampleFluent {
    public static void main(String[] args) {
        Predicate<Integer> even = number -> number % 2 == 0;
        Function1<Integer, Integer> doubler = number -> number + number;

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);


        System.out.println(numbers);


        Stream.of(Option.of(1), Option.of(2), Option.none())
                .flatMap(Function1.identity())
                .forEach(System.out::println);


    }
}
