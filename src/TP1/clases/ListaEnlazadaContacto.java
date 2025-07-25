/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1.clases;

/**
 *
 * @author Ulises
 */
public class ListaEnlazadaContacto {
    
    private class Nodo {

        private Contacto contacto;
        private Nodo siguiente;

        public Nodo(Contacto contacto) {
            this.contacto = contacto;
            this.siguiente = null;
        }

        public Contacto getContacto() {
            return contacto;
        }

        public void setContacto(Contacto contacto) {
            this.contacto = contacto;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    private Nodo primerNodo;
    private int cantidad;

    ListaEnlazadaContacto() {
        this.primerNodo = null;
        this.cantidad = 0;
    }

    public void insertarAlFinal(Contacto c) {
        Nodo nuevo = new Nodo(c);
        if (primerNodo == null) {
            primerNodo = nuevo;
        } else {
            Nodo actual = primerNodo;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        cantidad++;
    }

    public Contacto buscarPorNombre(String nombre) {
        Nodo actual = primerNodo;
        while (actual != null) {
            if (actual.contacto.getNombre().equals(nombre)) {
                return actual.contacto;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean borrarPorTelefono(String telefono) {
        if (primerNodo == null) {
            return false;
        }

        if (primerNodo.contacto.getTelefono().equals(telefono)) {
            primerNodo = primerNodo.siguiente;
            cantidad--;
            return true;
        }

        Nodo actual = primerNodo;
        while (actual.siguiente != null) {
            if (actual.siguiente.contacto.getTelefono().equals(telefono)) {
                actual.siguiente = actual.siguiente.siguiente;
                cantidad--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void listarContactos() {
        Nodo actual = primerNodo;
        while (actual != null) {
            actual.contacto.mostrar();
            actual = actual.siguiente;
        }
    }

    public int cantidad() {
        return cantidad;
    }

    public Contacto contactoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }
        Nodo actual = primerNodo;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.contacto;
    }
}
