/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.clases;

/**
 *
 * @author Ulises
 */
public class MAINTP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", "Gomez");
        Usuario u2 = new Usuario("Luis", "Perez");
        Usuario u3 = new Usuario("Laura", "Diaz");
        Usuario u4 = new Usuario("Juan", "Martinez");

        RedSocial red1 = new RedSocial();
        red1.registrar(u1);
        red1.registrar(u2);
        red1.registrar(u3);

        RedSocial red2 = new RedSocial();
        red2.registrar(u2);
        red2.registrar(u4);

        System.out.println("Red 1:");
        red1.mostrar();

        System.out.println("\nRed 2:");
        red2.mostrar();

        System.out.println("\n¿Luis es amigo común? " + RedSocial.esAmigoComun(red1, red2, u2));
        System.out.println("¿Ana es amiga común? " + RedSocial.esAmigoComun(red1, red2, u1));

        RedSocial union = RedSocial.union(red1, red2);
        System.out.println("\nUnión de Red 1 y Red 2:");
        union.mostrar();

        System.out.println("\nCantidad en Red 1: " + red1.cantidad());

        red1.echar(u2);
        System.out.println("\nRed 1 tras echar a Luis:");
        red1.mostrar();
    }
}

    

