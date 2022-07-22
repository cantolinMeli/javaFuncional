package com.platzi.functional._04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Wena comparito"));
        System.out.println(addMark.apply("Hola ctm"));

        BiFunction<String, Integer, String> leftPad =
                (text, number) -> {
                    return String.format("%" + number + "s", text);
                };
        System.out.println(leftPad.apply("Java", 10));
    }
}
