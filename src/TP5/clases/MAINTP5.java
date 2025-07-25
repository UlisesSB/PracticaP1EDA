/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.clases;

/**
 *
 * @author Ulises
 */
public class MAINTP5 {

    public static void main(String[] args) {

        Pila<String> pila = new Pila<>();

        // Push de elementos
        pila.push("a");
        pila.push("b");
        pila.push("c");
        System.out.print("Pila después de push: ");
        pila.mostrar();  // [c, b, a]

        // Top
        System.out.println("Top: " + pila.top()); // c

        // Fondo
        System.out.println("Fondo: " + pila.fondo()); // a

        // Pop
        pila.pop();
        System.out.print("Pila después de pop: ");
        pila.mostrar();  // [b, a]

        // Verificar top y fondo nuevamente
        System.out.println("Top: " + pila.top());   // b
        System.out.println("Fondo: " + pila.fondo()); // a
    }
}
