package demo;

import io.vavr.Function1;
import io.vavr.Function3;
import io.vavr.Lazy;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.function.Supplier;

public class Functions {
    public static void main(String[] args) {

        // Lifting
        Function1<Integer, Integer> factorial = (number) -> {
            if (number < 0) throw new IllegalArgumentException("Negative not allowed");
            if (number == 0) return 1;
            return Stream.range(1, number + 1)
                    .reduce((a, b) -> a * b);
        };
        Function1<Integer, Option<Integer>> lifted = Function1.lift(factorial);
        //System.out.println(lifted.apply(3));

        // Partial Application
        Function3<Integer, Integer, Integer, Integer> add = (a, b, c) -> a + b + c;
        System.out.println(add.apply(10, 20).apply(30));


        // Currying
        System.out.println(add.curried().apply(10).apply(20).apply(30));


        // Memoization
        Function1<Integer, Integer> costlyFunction = number -> {
            System.out.println("Computing for " + number);
            return number + 1;
        };

        Function1<Integer, Integer> memoized = costlyFunction.memoized();
        System.out.println(memoized.apply(10));
        System.out.println(memoized.apply(10));

        // Lazy

        Supplier<Integer> supplier = () -> {
            System.out.println("Getting value");
            return 10;
        };
        Lazy<Integer> lazyFn = Lazy.of(supplier);

        System.out.println(lazyFn.get());
        System.out.println(lazyFn.get());


    }
}
