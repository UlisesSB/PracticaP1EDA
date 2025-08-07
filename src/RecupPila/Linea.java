/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecupPila;

import java.util.Objects;

/**
 *
 * @author ulise
 */
public class Linea {

    private class Nodo {

        private Character dato;
        private Nodo siguiente;

        public Nodo(Character dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public Character getDato() {
            return dato;
        }

        public void setDato(Character dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

    }

    private Nodo ultimo;
    private int cantidad = 0;

    public static Linea lineaVacia() {
        return new Linea();
    }

    public Linea agregaALinea(Character item) {
        if (item == null) {
            return this;
        }

        Nodo nodoaux = new Nodo(item);

        if (this.esLineaVacia()) {
            this.ultimo = nodoaux;
        } else {
            nodoaux.setSiguiente(this.ultimo);
            this.ultimo = nodoaux;
        }

        cantidad++;
        return this;
    }

    public boolean esLineaVacia() {
        return this.ultimo == null;
    }

    public boolean perteneceLinea(Character item) {
        return perteneceLineaDesde(this.ultimo, item);
    }

    private boolean perteneceLineaDesde(Nodo nodo, Character item) {
        if (nodo == null) {
            return false;
        } else if (nodo.getDato().equals(item)) {
            return true;
        }
        return perteneceLineaDesde(nodo.getSiguiente(), item);
    }

    public Character ultimoLinea() {
        if (this.esLineaVacia()) {
            return null;
        } else {
            return ultimo.getDato();
        }
    }

    public Linea quitarLinea() {
        if (!this.esLineaVacia()) {
            this.ultimo = this.ultimo.getSiguiente();
        }
        cantidad--;
        return this;
    }

    public Integer longitud() {
        return this.cantidad;
    }

//    =====================================================================================
    public Linea copiar2() {
        Nodo aux1 = this.ultimo;
        Linea inv = Linea.lineaVacia();
        Linea copia = Linea.lineaVacia();

        while (aux1 != null) {
            inv.agregaALinea(aux1.getDato());
            aux1 = aux1.getSiguiente();
        }
        while (!inv.esLineaVacia()) {
            copia.agregaALinea(inv.ultimoLinea());
            inv.quitarLinea();
        }
        return copia;
    }

    public void mostrarIter() {
        Linea.Nodo nodoaux = this.ultimo;
        System.out.print("Linea (iterativa): [ ");
        while (nodoaux != null) {
            // Mientras haya nodos, se imprimen sus datos uno a uno.
            System.out.print(nodoaux.getDato() + " "); // Se imprime el dato actual.
            nodoaux = nodoaux.getSiguiente(); // Se avanza al siguiente nodo.
        }
        System.out.println("]");
    }
}
