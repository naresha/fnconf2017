package demo;

import io.vavr.API;
import io.vavr.Function1;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.net.URI;
import java.net.URISyntaxException;

public class UncheckException {
    public static void main(String[] args) {
        Stream.of("http://google.com", "%", "http://functionalconf.com")
                .map(UncheckException::createURI)
                .flatMap(Function1.identity())
                .forEach(System.out::println);

    }
    //sneaky throw

    public static Option<URI> createURI(String link) {
        URI uri;
        try {
            uri = new URI(link);
        } catch (URISyntaxException e) {
            return Option.none();
        }
        return Option.of(uri);
    }

}
