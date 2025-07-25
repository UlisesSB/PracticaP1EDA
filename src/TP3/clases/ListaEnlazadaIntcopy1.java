/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.clases;

import TP1.clases.*;

/**
 *
 * @author Ulises
 */
public class ListaEnlazadaIntcopy1 {

    /* clase Nodo anidada*/
    private class Nodo {

        /* atributos de Nodo*/
        private int dato;
        private Nodo siguiente;

        /* constructor de Nodo*/
        public Nodo(int num) {
            this.dato = num;
            this.siguiente = null;
        }

        /* get y set de Nodo*/
        public int getDato() {
            return dato;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    /* atributos de ListaEnlazada*/
    private Nodo primerNodo;
    /* primer nodo de la lista*/
    private Nodo colaNodo;
    /* variable que apunta al último nodo*/
    private int cantNodo;

    /* tamaño de la lista enlazada (cantidad de nodos)*/

 /* constructor de ListaEnlazada*/
    private ListaEnlazadaIntcopy1() {
        this.primerNodo = null;
        this.colaNodo = null;
        this.cantNodo = 0;
    }

    /*Instancia y devuelve una Lista*/
    public static ListaEnlazadaIntcopy1 crearLista() {
        return new ListaEnlazadaIntcopy1();
    }

    /*Comprueba si la lista está vacia*/
    boolean esVacia() {
        return this.primerNodo == null;
    }

    /*Inserta un Nodo al comienzo de la lista*/
    public ListaEnlazadaIntcopy1 insertarAlInicio(int x) {
        Nodo nodoAux = new Nodo(x);

        if (this.primerNodo == null) {
            this.colaNodo = nodoAux;
        }

        nodoAux.setSiguiente(this.primerNodo);
        this.primerNodo = nodoAux;

        this.cantNodo++;
        return this;
    }

    /*Inserta un Nodo al final de la lista*/
    public ListaEnlazadaIntcopy1 insertarAlFinal(int x) {
        Nodo nodoAux = new Nodo(x);

        if (this.primerNodo == null) {
            this.primerNodo = nodoAux;
            this.colaNodo = nodoAux;
        } else {
            this.colaNodo.setSiguiente(nodoAux);
            this.colaNodo = nodoAux;
        }

        this.cantNodo++;
        return this;
    }

    /*Devuelve la cantidad de nodos de la lista*/
    public int cantidad() {
        return this.cantNodo;
    }

    /*Devuelve el primer elemento de la lista*/
    public int primerElemento() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
        }
        return this.primerNodo.getDato();
    }

    /*Elimina el primer nodo de la Lista*/
    public ListaEnlazadaIntcopy1 borrarPrimero() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
            return this;
        }

        this.primerNodo = this.primerNodo.getSiguiente();

        if (this.primerNodo == null) {
            this.colaNodo = null;
        }

        this.cantNodo--;
        return this;
    }

    /*Elimina el ultimo nodo de la Lista*/
    public ListaEnlazadaIntcopy1 borrarUltimo() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
            return this;
        }

        if (this.primerNodo == this.colaNodo) {
            this.primerNodo = null;
            this.colaNodo = null;
        } else {
            Nodo nodoAux = this.primerNodo;
            while (nodoAux.getSiguiente() != this.colaNodo) {
                nodoAux = nodoAux.getSiguiente();
            }

            nodoAux.setSiguiente(null);
            this.colaNodo = nodoAux;
        }

        this.cantNodo--;
        return this;
    }

    /*Determina si un elemento pertenece a la lista*/
    public boolean pertenece(int buscado) {
        Nodo actual = this.primerNodo;
        while (actual != null) {
            if (actual.getDato() == buscado) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /* Elimina todos los nodos que contengan el valor igual a x */
    public ListaEnlazadaIntcopy1 borrarConValor(int buscado) {
        while (this.primerNodo != null && this.primerNodo.getDato() == buscado) {
            this.primerNodo = this.primerNodo.getSiguiente();
            this.cantNodo--;
        }

        if (this.primerNodo == null) {
            this.colaNodo = null;
            return this;
        }

        Nodo actual = this.primerNodo;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato() == buscado) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                this.cantNodo--;
            } else {
                actual = actual.getSiguiente();
            }
        }

        // Actualizar colaNodo si es necesario
        this.colaNodo = this.primerNodo;
        while (this.colaNodo != null && this.colaNodo.getSiguiente() != null) {
            this.colaNodo = this.colaNodo.getSiguiente();
        }

        return this;
    }

    /*Devuelve el contenido del nodo en la posición posicion*/
    public int valorEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.cantNodo) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }

        Nodo actual = this.primerNodo;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    /*Modificar el contenido del nodo de la posición posicion*/
    public ListaEnlazadaIntcopy1 modificarValorEnPosicion(int valor, int posicion) {
        if (posicion < 0 || posicion >= this.cantNodo) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }

        Nodo actual = this.primerNodo;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(valor);
        return this;
    }

    /*Inserta un nodo en la posición posición con valor valor*/
    public ListaEnlazadaIntcopy1 insertarEnPosicion(int valor, int posicion) {
        if (posicion < 0 || posicion > this.cantNodo) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }

        if (posicion == 0) {
            return insertarAlInicio(valor);
        } else if (posicion == this.cantNodo) {
            return insertarAlFinal(valor);
        } else {
            Nodo nuevoNodo = new Nodo(valor);
            Nodo actual = this.primerNodo;

            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            this.cantNodo++;

            return this;
        }
    }

    /* punto 3, tp3*/
 /*Metodo de entrada publicoa a la suma de enteros almacenados*/
    public int sumarMayoresQue(int umbral) {
        return sumarRecursivo(this.primerNodo, umbral);
    }

    /*Metodo recursivo privado que suma de los enteros almacenados en los nodos cuyo valor sea superior a un valor umbral pasado como parámetro*/
    private int sumarRecursivo(Nodo nodo, int umbral) {
        if (nodo == null) {
            return 0;
        }

        int sumaRestante = sumarRecursivo(nodo.getSiguiente(), umbral);

        if (nodo.getDato() > umbral) {
            return nodo.getDato() + sumaRestante;
        } else {
            return sumaRestante;
        }
    }

    /* punto 4, tp3*/
    /*Metodo de entrada publicoa a mostrar*/
    public void mostrar() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
        } else {
            mostrarRecursivo(this.primerNodo);
        }
    }

    /*Metodo recursivo privado que se usa para mostrar*/
    private void mostrarRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getDato());
        if (nodo.getSiguiente() != null) {
            System.out.print(" | ");
        }
        mostrarRecursivo(nodo.getSiguiente());
    }

    /* punto 5, tp3*/
    /*Metodo publico de entrada a que devuelva el valor mayor en la lista*/
    public int mayor() {
        if (this.primerNodo == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return mayorRecursivo(this.primerNodo);
    }

    /*Metodo recursivo privado que devuelva el valor mayor en la lista*/
    private int mayorRecursivo(Nodo nodo) {
        // Caso base: si estamos en el último nodo, devolvemos su valor
        if (nodo.getSiguiente() == null) {
            return nodo.getDato();
        }

        // Caso recursivo: obtener el mayor del resto y comparar con el actual
        int mayorDelResto = mayorRecursivo(nodo.getSiguiente());
        return Math.max(nodo.getDato(), mayorDelResto);
    }
    
    /* punto 6, tp3 (INCOMPLETO)*/
    
}
