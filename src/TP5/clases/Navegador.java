/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.clases;

/**
 *
 * @author Ulises
 */
public class Navegador {

    private Pila<Integer> pilaAtras;
    private Pila<Integer> pilaAdelante;
    private Integer urlActual;

    public Navegador() {
        pilaAtras = new Pila<>();
        pilaAdelante = new Pila<>();
        urlActual = null; // No hay página al inicio
    }

    public void navegar(int url) {
        if (urlActual != null) {
            pilaAtras.push(urlActual);
        }
        urlActual = url;
        pilaAdelante = new Pila<>(); // Limpiar pila de adelante al navegar nuevo
        System.out.println("Navegando a: " + urlActual);
    }

    public Integer atras() {
        if (pilaAtras.esVacia()) {
            System.out.println("No hay páginas anteriores.");
            return urlActual;
        }
        pilaAdelante.push(urlActual);
        urlActual = pilaAtras.top();
        pilaAtras.pop();
        System.out.println("Volviendo a: " + urlActual);
        return urlActual;
    }

    public Integer adelante() {
        if (pilaAdelante.esVacia()) {
            System.out.println("No hay páginas siguientes.");
            return urlActual;
        }
        pilaAtras.push(urlActual);
        urlActual = pilaAdelante.top();
        pilaAdelante.pop();
        System.out.println("Avanzando a: " + urlActual);
        return urlActual;
    }

    public Integer obtenerURLActual() {
        return urlActual;
    }
    
    public static void main(String[] args) {
        Navegador navegador = new Navegador();

        navegador.navegar(1); // Página 1
        navegador.navegar(2); // Página 2
        navegador.navegar(3); // Página 3

        navegador.atras(); // Volver a 2
        navegador.atras(); // Volver a 1

        navegador.adelante(); // Adelante a 2

        navegador.navegar(4); // Nueva navegación, borra adelante

        navegador.adelante(); // Nada a donde ir
    }
}


