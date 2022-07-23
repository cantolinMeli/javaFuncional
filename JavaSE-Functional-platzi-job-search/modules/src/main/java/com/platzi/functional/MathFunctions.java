package com.platzi.functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        //Esta sintaxis es válida, pero más difícil de leer
        Function<Integer, Integer> square =
                new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println("5 al cuadrado: " + square.apply(5));
        System.out.println("25 al cuadrado: " + square.apply(25));

        //Expresión lambda, es más legible y sencilla
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        //Las funciones PREDICATE sirven para validar cosas
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Resultado de la función Predicate: " + isEven.test(4)); //Devuelve true

        //Creamos una función Predicate para saber si un estudiante pasa un ramo o no de acuerdo a su nota
        //La función Predicate devuelve true si la nota del estudiante es mayor o igual a 6
        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6;

        //Creamos un estudiante con nota 5.9
        Student compare = new Student(5.9);

        /* Creamos un String que devuelve un texto dependiendo del resultado de la Función Predicate
        Para esto utilizamos un if ternario */

        String salida = isApproved.test(compare) ? "El estudiante aprueba" : "El estudiante reprueba";

        //Se imprime el resultado
        System.out.println(salida);
    }

    static class Student {
        private double calificacion;

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }
        public double getCalificacion() {
            return calificacion;
        }
    }
}
