/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecupPila;

/**
 *
 * @author Ulises
 */
public class MAINTP5 {

    public static void main(String[] args) {
        // Crear una pila vacía
        Pila pila1 = Pila.pilaVacia();

        System.out.println("=== Probando operaciones básicas ===");
        System.out.println("¿Pila vacía? " + pila1.esPilaVacia());

        // Apilar elementos
        pila1.push(10).push(20).push(30).push(20).push(40);
        System.out.println("\nDespués de apilar 10, 20, 30, 20, 40:");
        pila1.mostrarIter();

        System.out.println("\n=== Probando funciones adicionales ===");
        System.out.println("Top: " + pila1.top());
        System.out.println("Fondo: " + pila1.fondo());
        System.out.println("Altura (iterativa): " + pila1.alturaIter());
        System.out.println("Altura (recursiva): " + pila1.alturaRecur());
        System.out.println("Altura (01): " + pila1.altura01());

        // Mostrar de forma recursiva
        System.out.println("\nMostrando pila recursivamente:");
        pila1.mostrarRecur();

        // Probando pop
        System.out.println("\n=== Probando pop ===");
        pila1.pop();
        System.out.println("Después de pop:");
        pila1.mostrarIter();

        // Probando copiar
        System.out.println("\n=== Probando copiar ===");
        Pila copia = pila1.copiar();
        System.out.println("Copia de la pila:");
        copia.mostrarIter();

        // Probando invertir
        System.out.println("\n=== Probando invertir ===");
        Pila invertida = pila1.invertir();
        System.out.println("Pila invertida:");
        invertida.mostrarIter();

        // Probando pertenece
        System.out.println("\n=== Probando pertenece ===");
        System.out.println("¿20 está en la pila? " + pila1.pertenece(20));
        System.out.println("¿50 está en la pila? " + pila1.pertenece(50));

        // Probando apilarCoincidencia
        System.out.println("\n=== Probando apilarCoincidencia (20) ===");
        Pila coincidencias = pila1.apilarCoincidencia(20);
        System.out.println("Pila con coincidencias de 20:");
        coincidencias.mostrarIter();

        // Probando apilar otra pila
        System.out.println("\n=== Probando apilar otra pila ===");
        Pila pila2 = Pila.pilaVacia();
        pila2.push(100).push(200).push(300);
        System.out.println("Pila2:");
        pila2.mostrarIter();

        System.out.println("\nApilar pila2 sobre pila1 (iterativo):");
        Pila apiladaIter = pila1.apilarIter(pila2);
        apiladaIter.mostrarIter();

        System.out.println("\nApilar pila2 sobre pila1 (recursivo):");
        Pila apiladaRecur = pila1.apilarRecur(pila2);
        apiladaRecur.mostrarIter();

        // Probando clear
        System.out.println("\n=== Probando clear ===");
        pila1.clear();
        System.out.println("Después de clear:");
        pila1.mostrarIter();
        System.out.println("¿Pila vacía? " + pila1.esPilaVacia());

        // Probando Mayorque
        Pila pila = Pila.pilaVacia();
        pila.push(5).push(10).push(3).push(8).push(1).push(7);

        System.out.println("=== Pila original ===");
        pila.mostrarIter(); // [5, 10, 3, 8, 1, 7]

        System.out.println("\n=== Probando mayorQue(5) (Iterativo) ===");
        Pila mayoresQue5 = pila.mayorQue(5);
        mayoresQue5.mostrarIter(); // [10, 8, 7]

        System.out.println("\n=== Probando mayorQueRecursivo(3) (Recursivo) ===");
        Pila mayoresQue3 = pila.mayorQueRecursivo(3);
        mayoresQue3.mostrarIter(); // [5, 10, 8, 7]

        System.out.println("\n=== Probando con un valor que no existe (mayorQue(20)) ===");
        Pila mayoresQue20 = pila.mayorQue(20);
        mayoresQue20.mostrarIter(); // [] (Pila vacía)
    }

    public int altura(Pila p) {
        if (p.esPilaVacia()) {
            return 0;
        }
        return 1 + altura(p.pop());
    }

    public boolean igualP(Pila p1, Pila p2) {
        if (p1.esPilaVacia() && p2.esPilaVacia()) {
            return true;
        }
        if (p1.esPilaVacia() || p2.esPilaVacia()) {
            return false;
        }
        if (!p1.top().equals(p2.top())) {
            return false;
        }
        return igualP(p1.pop(), p2.pop());
    }

    public int contarOcurrencias(Pila p, int x) {
        if (p.esPilaVacia()) {
            return 0;
        }

        int cuentaResto = contarOcurrencias(p.pop(), x);

        if (p.top().equals(x)) {
            return 1 + cuentaResto;
        } else {
            return cuentaResto;
        }
    }

    public boolean subpila(Pila p1, Pila p2) {
        if (p1.esPilaVacia()) {
            return true;     // Subpila vacía siempre está
        }
        if (p2.esPilaVacia()) {
            return false;    // Si p2 se vacía antes que p1 → falso
        }
        if (p1.top().equals(p2.top())) {
            return subpila(p1.pop(), p2.pop()); // Coinciden: seguir con ambos
        } else {
            return subpila(p1, p2.pop());       // No coinciden: avanzar p2
        }
    }

    public boolean esPalindromo(Pila p) {
        Pila copia = p.copiar();
        Pila invertida = p.invertir();
        return copia.esIgual(invertida);
    }

}
