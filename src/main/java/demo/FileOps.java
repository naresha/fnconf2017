package demo;

import io.vavr.API;
import io.vavr.collection.Stream;
import io.vavr.control.Try;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOps {
    public static void main(String[] args) {
        Stream.of(10, 20, 30, 40)
                .map(number -> number.toString() + ".txt")
                .map(path -> Paths.get("./", path))
                .map(value -> Try.of(() -> readContent(value)))
                        .forEach(System.out::println);


    }

    public static String readContent(Path path) throws IOException {
        return Files.newBufferedReader(path).readLine();
    }
}
