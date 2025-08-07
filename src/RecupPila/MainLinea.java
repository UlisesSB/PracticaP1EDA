/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecupPila;

/**
 *
 * @author ulise
 */
public class MainLinea {

    public static void main(String[] args) {
        Linea linea1 = Linea.lineaVacia();

        System.out.println(linea1.esLineaVacia());

        linea1.agregaALinea('A').agregaALinea('B').agregaALinea('C').agregaALinea('A').agregaALinea('D');
        linea1.mostrarIter();
        System.out.println(linea1.esLineaVacia());

        System.out.println(linea1.ultimoLinea());

        System.out.println(linea1.longitud());

        System.out.println(linea1.perteneceLinea('A'));
        System.out.println(linea1.perteneceLinea('2'));

        linea1.quitarLinea();
        linea1.mostrarIter();

        System.out.println(repiteLinea(linea1));

        Linea linea2 = Linea.lineaVacia();
        linea2.agregaALinea('A').agregaALinea('B').agregaALinea('C').agregaALinea('A').agregaALinea('D');
        Linea linea3 = Linea.lineaVacia();
        linea3.agregaALinea('A').agregaALinea('B').agregaALinea('C').agregaALinea('A');
//        linea3.quitarLinea();
        Linea linea4 = Linea.lineaVacia();
        linea4.agregaALinea('A').agregaALinea('B').agregaALinea('C').agregaALinea('A');
        linea4.quitarLinea();

        System.out.println(igualLinea(linea1, linea2));
        linea2.mostrarIter();
        System.out.println(igualLinea(linea1, linea3));
        linea3.mostrarIter();
    }

    public static int repiteLinea(Linea linea) {
        Character ultimoaux = linea.ultimoLinea();
        int contador = 0;
        if (linea.esLineaVacia()) {
            return contador;
        }

        while (!linea.esLineaVacia()) {
            if (linea.ultimoLinea().equals(ultimoaux)) {
                contador++;
            }
            linea.quitarLinea();
        }
        return contador;
    }

    public static boolean igualLinea(Linea l1, Linea l2) {
        return igualLineaPriv(l1.copiar2(), l2.copiar2());
    }

    private static boolean igualLineaPriv(Linea l1, Linea l2) {
        if (l1.esLineaVacia() && l2.esLineaVacia()) {
            return true;
        }
        if (l1.esLineaVacia() || l2.esLineaVacia()) {
            return false;
        }
        if (!l1.ultimoLinea().equals(l2.ultimoLinea())) {
            return false;
        }
        return igualLineaPriv(l1.quitarLinea(), l2.quitarLinea());
    }

}
