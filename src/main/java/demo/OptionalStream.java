package demo;

import io.vavr.Function1;
import io.vavr.control.Option;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalStream {
    public static void main(String[] args) {
        Stream.of(Optional.of(1), Optional.of(2), Optional.empty())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

    }
}
