package demo;

import io.vavr.Tuple2;
import io.vavr.collection.Stream;

import java.io.Serializable;

public class Fizzbuzz {
    public static void main(String[] args) {

        // 1 2 FIZZ 4 BUZZ FIZZ 7 8 FIZZ BUZZ ...

        Stream<String> fizz = Stream.of("", "", "FIZZ").cycle();
        Stream<String> buzz = Stream.of("", "", "", "", "BUZZ").cycle();
        Stream<String> fizzbuzz = fizz.zipWith(buzz, (left, right) -> left + right);
        Stream<? extends Serializable> result = fizzbuzz.zipWithIndex((left, right) -> left.length() > 0 ? left : right);
        result.take(16).forEach(System.out::println);
    }
}
