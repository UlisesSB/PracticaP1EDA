/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TP3.clases;

/**
 *
 * @author ulisesSB
 */
public class MAINTP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Punto 1
        int numero = 123456;
        int digito = 7;

        if (MetodosRecursivos.digitoAusente(numero, digito)) {
            System.out.println("El dígito " + digito + " NO está en el número " + numero);
        } else {
            System.out.println("El dígito " + digito + " SÍ está en el número " + numero);
        }

        //punto 2
        char[] palabra = {'r', 'a', 'd', 'a', 'r'};

        if (MetodosRecursivos.esPalindromo(palabra)) {
            System.out.println("La palabra es un palíndromo.");
        } else {
            System.out.println("La palabra NO es un palíndromo.");
        }

        //punto3
        ListaEnlazadaIntcopy1 lista = ListaEnlazadaIntcopy1.crearLista();
        lista.insertarAlFinal(10).insertarAlFinal(25).insertarAlFinal(5).insertarAlFinal(30);

        int umbral = 15;
        int suma = lista.sumarMayoresQue(umbral);
        System.out.println("Suma de valores mayores que " + umbral + ": " + suma);
    }
}
