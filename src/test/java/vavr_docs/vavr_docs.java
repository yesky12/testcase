package vavr_docs;

import io.vavr.*;
import io.vavr.collection.Stream;

public class vavr_docs {
    public static void main(String[] args) {
        // = Stream("1", "2", "3") in Vavr
        Stream<String> strings = Stream.of(1, 2, 3).map(Object::toString);
        System.out.println("strings="+strings);

        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        String s = java8._1;
        System.out.println("s=" + s);
    }
}
