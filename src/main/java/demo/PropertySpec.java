package demo;

import io.vavr.Function1;
import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;

public class PropertySpec {
    public static void main(String[] args) {
        Function1<String, String> reverse = s -> {
            return new StringBuilder(s).reverse().toString();
        };

        Arbitrary<String> string = Arbitrary.string(Gen.choose('A', 'Z'));
        System.out.println(string);

        Property.def("reverse")
                .forAll(string)
                .suchThat(s -> {
                    //System.out.println(s);
                    return reverse.apply(reverse.apply(s)).equals(s);
                })
                .check()
                .assertIsSatisfied();
    }
}
