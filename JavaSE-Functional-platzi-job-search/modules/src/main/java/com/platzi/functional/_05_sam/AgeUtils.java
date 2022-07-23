package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {

    public static void main(String[] args) {
        //Función que antepone un cero a cualquier valor menor de 10
        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        //Función que hereda del método de la interface. Parsea a date una fecha ingresada como String
        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" +addCeros.apply(month) + "-" + day);

        /*Función que hereda del método de la interface.
        Calcula la diferencia en años entre la fecha ingresada y la fecha de hoy
         */
        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year), LocalDate.now()
                ).getYears();

        System.out.println(calculateAge.apply(16, 11, 1982));
    }

    /*SAM is the abbreviation of Single Abstract Method.
    A functional interface is an interface that contains only one abstract method.
    They can have only one functionality to exhibit.*/

    @FunctionalInterface //Esta notación define que la interfaz se va a usar como una función
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
