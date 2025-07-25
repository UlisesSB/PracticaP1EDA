/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.clases;

/**
 *
 * @author Ulises
 */
public class MetodosRecursivos {

    /*Determina si un dígito D NO PERTENECE al número dado*/
    public static boolean digitoAusente(int num, int d) {
        num = Math.abs(num); // Asegurarse de que el número sea positivo

        // Caso base: si el número es 0, solo el dígito 0 podría estar presente
        if (num == 0) {
            return d != 0;
        }

        // Si el último dígito es igual a d, entonces sí pertenece (no está ausente)
        if (num % 10 == d) {
            return false;
        }

        // Llamada recursiva eliminando el último dígito
        return digitoAusente(num / 10, d);
    }

    /*Determina si el vector contiene una palabra palíndrome.*/
    public static boolean esPalindromo(char[] palabra) {
        return esPalindromoRecursivo(palabra, 0, palabra.length - 1);
    }

    private static boolean esPalindromoRecursivo(char[] palabra, int inicio, int fin) {
        // Caso base: si los índices se cruzan o se igualan, ya comparaste todo
        if (inicio >= fin) {
            return true;
        }

        // Si los caracteres no coinciden, no es palíndromo
        if (palabra[inicio] != palabra[fin]) {
            return false;
        }

        // Llamada recursiva para los siguientes caracteres
        return esPalindromoRecursivo(palabra, inicio + 1, fin - 1);
    }



}
