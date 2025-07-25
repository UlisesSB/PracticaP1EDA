package TP1.clases;

public class ListaEnlazada {

    // Clase Nodo que representa cada elemento de la lista
    private class Nodo {
        private int dato;
        private Nodo siguiente;

        public Nodo(int num) {
            this.dato = num;
            this.siguiente = null;
        }

        public int getDato() { return dato; }
        public void setDato(int dato) { this.dato = dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    // Atributos de la lista enlazada
    private Nodo primerNodo;
    private Nodo colaNodo;
    private int cantNodo;

    // ======================= MÉTODOS ADT =======================

    // Crea e instancia una lista vacía
    public static ListaEnlazada crearLista() {
        return new ListaEnlazada();
    }

    // Verifica si la lista está vacía
    public boolean esVacia() {
        return this.primerNodo == null;
    }

    // Inserta un nodo al inicio de la lista
    public ListaEnlazada insertarAlInicio(int x) {
        Nodo nodoAux = new Nodo(x);
        if (this.primerNodo == null) {
            this.colaNodo = nodoAux;
        }
        nodoAux.setSiguiente(this.primerNodo);
        this.primerNodo = nodoAux;
        this.cantNodo++;
        return this;
    }

    // Inserta un nodo al final de la lista
    public ListaEnlazada insertarAlFinal(int x) {
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

    // Elimina el primer nodo de la lista
    public ListaEnlazada borrarPrimero() {
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

    // Elimina el último nodo de la lista
    public ListaEnlazada borrarUltimo() {
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

    // Devuelve el valor del primer elemento de la lista
    public int primerElemento() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
        }
        return this.primerNodo.getDato();
    }

    // Inserta un nodo en una posición específica de la lista
    public ListaEnlazada insertarEnPosicion(int valor, int posicion) {
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

    // Elimina todos los nodos que contengan un valor específico
    public ListaEnlazada borrarConValor(int buscado) {
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
        this.colaNodo = this.primerNodo;
        while (this.colaNodo != null && this.colaNodo.getSiguiente() != null) {
            this.colaNodo = this.colaNodo.getSiguiente();
        }
        return this;
    }

    // ======================= MÉTODOS NO ADT =======================

    // Muestra el contenido de la lista por pantalla
    public void mostrar() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
            return;
        }
        Nodo nodoAux = this.primerNodo;
        while (nodoAux != null) {
            System.out.println(nodoAux.getDato());
            nodoAux = nodoAux.getSiguiente();
            if (nodoAux != null) {
                System.out.println(" | ");
            }
        }
    }

    // Devuelve la cantidad de nodos en la lista
    public int cantidad() {
        return this.cantNodo;
    }

    // Determina si un valor pertenece a la lista
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

    // Devuelve el valor del nodo en una posición específica
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

    // Modifica el valor de un nodo en una posición específica
    public ListaEnlazada modificarValorEnPosicion(int valor, int posicion) {
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
}
