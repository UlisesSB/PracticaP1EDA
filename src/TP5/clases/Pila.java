package TP5.clases;

import java.util.EmptyStackException;

public class Pila<T> {

    // Clase interna que representa un nodo de la pila
    private class Nodo {

        T dato;
        Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

    }

    private Nodo cima; // Referencia al nodo en la cima de la pila

    // ===================== MÉTODOS ADT =====================
    // Método estático que crea e instancia una pila vacía
    public static <T> Pila<T> crearPila() {
        return new Pila<>();
    }

    // Verifica si la pila está vacía
    public boolean esVacia() {
        return cima == null;
    }

    // Inserta un elemento en la cima de la pila
    public void push(T item) {
        Nodo nuevo = new Nodo(item);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    // Elimina y retorna el elemento en la cima de la pila
    public T pop() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    // Retorna el elemento en la cima sin eliminarlo
    public T top() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        return cima.dato;
    }

    // ===================== MÉTODOS NO ADT =====================
    // Retorna el elemento en el fondo de la pila
    public T fondo() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        Nodo actual = cima;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    // Muestra el contenido de la pila desde la cima hasta el fondo
    public void mostrar() {
        Nodo actual = cima;
        System.out.print("Pila: [ ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }

    // Retorna la cantidad de elementos en la pila
    public int size() {
        int contador = 0;
        Nodo actual = cima;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Elimina todos los elementos de la pila
    public void clear() {
        cima = null;
    }

    // Retorna una cadena con la representación de la pila
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila: [ ");
        Nodo actual = cima;
        while (actual != null) {
            sb.append(actual.dato).append(" ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
