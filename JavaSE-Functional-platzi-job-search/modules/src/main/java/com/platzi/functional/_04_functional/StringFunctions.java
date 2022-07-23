package com.platzi.functional._04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        /*UnaryOPerator --> Solo se especifica un solo tipo de dato.
        Se entiende que tendrá como resultado el mismo tipo de dato*/
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Wena comparito"));
        System.out.println(addMark.apply("Hola ctm"));

        /* Ojo: BinaryOperator --> en él se especifica un tipo de dato.
        Se entiende que tendrá 2 parámetros de entrada y retorna el mismo tipo de dato.*/

        /* Bifunction --> 2 parámetros de entrada, se tiene que especificar el tipo de dato.
        Puede tener diferentes tipos de entradas como también diferente tipo de salida. */
        BiFunction<String, Integer, String> leftPad =
                (text, number) -> {
                    return String.format("%" + number + "s", text);
                };
        System.out.println(leftPad.apply("Java", 10));
    }
}
