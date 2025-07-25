/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.clases;

/**
 *
 * @author Ulises
 */
public class BalanceoParentesis {

    public static boolean estaBalanceado(String expresion) {
        Pila<Character> pila = new Pila<>();

        for (int i = 0; i < expresion.length(); i++) {
            char ch = expresion.charAt(i);
            if (ch == '(') {
                pila.push(ch);
            } else if (ch == ')') {
                if (pila.esVacia()) {
                    return false; // Paréntesis de cierre sin apertura
                }
                pila.pop(); // Cierra un paréntesis abierto
            }
        }

        return pila.esVacia(); // Debe estar vacía si está balanceada
    }

    public static void main(String[] args) {
        String expr1 = "(a + b) * (c + d)";
        String expr2 = "(a + b * (c - d)";
        String expr3 = "((a + b) - c) + ((d))";

        System.out.println("Expr1: " + estaBalanceado(expr1)); // true
        System.out.println("Expr2: " + estaBalanceado(expr2)); // false
        System.out.println("Expr3: " + estaBalanceado(expr3)); // true
    }
}
