/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecupPila;

/**
 *
 * @author ulise
 */
public class Pila {

    //  Clase interna nodo.
    private class Nodo {

        private Integer dato;
        private Nodo siguiente;

        public Nodo(Integer dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public Integer getDato() {
            return dato;
        }

        public void setDato(Integer dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

    }

    //  Atributos de la pila.
    private Nodo cima;
    private Integer cantidad01 = 0;

    public static Pila pilaVacia() {
        // Devuelve una pila nueva.
        return new Pila();
    }

    public boolean esPilaVacia() {
        // Dice false o true segun si la cima es vacia.
        return this.cima == null;
    }

    public Pila push(Integer item) {
        Nodo nodoaux = new Nodo(item);
        if (item == null) {
            // Si el dato es null, no se agrega nada.
            return this;
        }
        if (this.esPilaVacia()) {
            // Si la pila está vacía, el nuevo nodo será cima.
            this.cima = nodoaux;
        } else {
            // Si ya hay elementos, se enlaza el nuevo y se establece como cima.
            nodoaux.siguiente = this.cima;
            this.cima = nodoaux;
        }
        cantidad01++;
        return this;
    }

    public Integer top() {
        if (this.esPilaVacia()) {
            // Si es vacia devuelve nulo.
            return null;
        } else {
            // Si es vacia devuelve el dato de la cima.
            return this.cima.getDato();
        }
    }

    public Pila pop() {
        if (!this.esPilaVacia()) {
            // Si tiene elementos que borrar entonces establece la cima al elemento de abajo.
            this.cima = this.cima.siguiente;
        }
        cantidad01--;
        return this;
    }

//=============================== Agregando Funciones al ADT ========================================
    public Integer fondo() {
        if (this.esPilaVacia()) {
            // Si es vacia, el fondo es null
            return null;
        }
        Nodo nodoaux = this.cima;
        while (nodoaux.getSiguiente() != null) {
            // Borrara el auxiliar hasta que llegue al ultimo
            nodoaux = nodoaux.getSiguiente();
        }
        return nodoaux.dato;// Devuelve el ultimo que quedo del while
    }

    public void mostrarIter() {
        Nodo nodoaux = this.cima;
        System.out.print("Pila (iterativa): [ ");
        while (nodoaux != null) {
            // Mientras haya nodos, se imprimen sus datos uno a uno.
            System.out.print(nodoaux.getDato() + " "); // Se imprime el dato actual.
            nodoaux = nodoaux.getSiguiente(); // Se avanza al siguiente nodo.
        }
        System.out.println("]");
    }

    public void mostrarRecur() {
        System.out.print("Pila (recursiva): [ ");
        // Llama a la función recursiva que imprime desde la cima hacia abajo.
        mostrarDesde(this.cima);
        System.out.println("]");
    }

    private void mostrarDesde(Nodo nodoaux) {
        // Caso base: si el nodo es null, termina la recursión.
        if (nodoaux != null) {
            System.out.print(nodoaux.getDato() + " "); // Imprime el dato actual.
            mostrarDesde(nodoaux.getSiguiente());     // Llama recursivamente al siguiente nodo.
        }
    }

    public Integer altura01() {
        // Devuelve la cantidad pero con la variable del inicio para ser costo 01.
        return this.cantidad01;
    }

    public Integer alturaIter() {
        Nodo nodoaux = this.cima;
        Integer cant = 0;

        while (nodoaux != null) {
            // Recorre la pila sumando uno por cada nodo.
            cant++; // Suma uno por cada nodo visitado.
            nodoaux = nodoaux.getSiguiente(); // Avanza al siguiente nodo.
        }
        return cant; // Devuelve el total contado.
    }

    public Integer alturaRecur() {
        // Llama al método recursivo auxiliar con el nodo cima.
        return alturaDesde(this.cima);
    }

    public Integer alturaDesde(Nodo nodoaux) {
        if (nodoaux == null) {
            // Caso base: si el nodo es null, se terminó la pila.
            return 0;
        } else {
            // Llama recursivamente al siguiente nodo y suma 1 por cada nivel.
            return 1 + this.alturaDesde(nodoaux.getSiguiente());
        }
    }

    // Elimina todos los elementos de la pila
    public void clear() {
        cima = null;
    }

    public Pila copiar() {
        Pila aux = Pila.pilaVacia();
        Pila copia = Pila.pilaVacia();
        Nodo actual = this.cima;

        while (actual != null) {
            // Apilamos los elementos en aux (invierte el orden)
            aux = aux.push(actual.getDato());  // Apila el dato en aux
            actual = actual.getSiguiente();    // Avanza al siguiente nodo
        }
        while (!aux.esPilaVacia()) {
            // Apilamos desde aux a copia para restaurar el orden original
            copia = copia.push(aux.top()); // Recupera el tope de aux y lo apila en copia
            aux = aux.pop();               // Elimina el tope de aux
        }
        return copia; // Devolvemos la pila clonada
    }

    public Pila invertir() {
        Pila invertida = Pila.pilaVacia();
        Nodo actual = this.cima;

        while (actual != null) {
            invertida = invertida.push(actual.getDato()); // Apila en orden inverso
            actual = actual.getSiguiente();
        }
        return invertida;
    }

    public Pila copiarConInvertir() {
        Pila inversa = this.invertir(); // Invertir la pila actual (queda en orden inverso)
        return inversa.invertir(); // Invertir esa pila nuevamente, recuperando el orden original
    }

    public boolean pertenece(Integer x) {
        // Llama al método recursivo auxiliar con el nodo cima.
        return perteneceDesde(this.cima, x);
    }

    private boolean perteneceDesde(Nodo nodo, Integer x) {
        if (nodo == null) {
            return false; // Llegamos al final sin encontrar el dato
        }
        if (nodo.getDato().equals(x)) {
            return true; // Coincidencia encontrada
        }
        return perteneceDesde(nodo.getSiguiente(), x); // Llamada recursiva
    }

    public Pila apilarCoincidencia(Integer x) {
        // Llama al método recursivo auxiliar con el nodo cima.
        return apilarCoincidenciaDesde(this.cima, x);
    }

    private Pila apilarCoincidenciaDesde(Nodo nodo, Integer x) {
        if (nodo == null) {
            return Pila.pilaVacia(); // Pila vacía
        }

        // Llamada recursiva primero (para preservar el orden)
        Pila resultado = apilarCoincidenciaDesde(nodo.getSiguiente(), x);

        if (nodo.getDato().equals(x)) {
            // Si coincide, apilamos este elemento sobre lo que viene después
            return resultado.push(nodo.getDato());
        } else {
            // Si no coincide, devolvemos lo que ya se construyó
            return resultado;
        }
    }

    public Pila apilarIter(Pila otra) {
        //Invertir la pila 'otra' para preservar su orden
        Pila aux = otra.invertir();

        //Apilar cada elemento de aux sobre esta pila
        Nodo actual = aux.cima;
        Pila resultado = this;

        while (actual != null) {
            resultado = resultado.push(actual.getDato());
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Pila apilarRecur(Pila otra) {
        // Llama al método recursivo auxiliar con el nodo cima.
        return apilarDesde(this, otra.cima);
    }

    private Pila apilarDesde(Pila base, Nodo nodo) {
        if (nodo == null) {
            return base; // Caso base: si 'otra' está vacía, devolvemos 'this'
        } else {
            // Paso recursivo: primero apilamos el resto, luego este nodo
            Pila parcial = apilarDesde(base, nodo.getSiguiente());
            return parcial.push(nodo.getDato());
        }
    }

    public Pila mayorQue(Integer item) {
        Pila resultado = Pila.pilaVacia();
        Nodo actual = this.cima;

        while (actual != null) {
            if (actual.getDato() > item) { // Si el elemento es mayor que 'item'
                resultado.push(actual.getDato()); // Lo apilamos en el resultado
            }
            actual = actual.getSiguiente(); // Avanzamos al siguiente nodo
        }

        // La pila resultado está en orden inverso (debido al push), así que la invertimos
        return resultado.invertir();
    }

    public Pila mayorQueRecursivo(Integer item) {
        Pila resultado = Pila.pilaVacia();
        return mayorQueDesde(this.cima, item, resultado).invertir();
    }

    private Pila mayorQueDesde(Nodo nodo, Integer item, Pila resultado) {
        if (nodo == null) {
            return resultado; // Llegamos al final
        }
        if (nodo.getDato() > item) {
            resultado.push(nodo.getDato()); // Apilamos si cumple la condición
        }
        return mayorQueDesde(nodo.getSiguiente(), item, resultado); // Llamada recursiva
    }
}
