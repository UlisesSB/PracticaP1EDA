/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TP1.clases;

/**
 *
 * @author ulisesSB
 */
public class MAINTP1 {

    public static void main(String[] args) {
        // Crear lista vacía
        ListaEnlazada lista = ListaEnlazada.crearLista();

        System.out.println("¿Lista vacía? " + lista.esVacia());

        // Insertar elementos
        lista.insertarAlInicio(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlInicio(5);
        lista.insertarEnPosicion(15, 2);

        System.out.println("\nContenido de la lista:");
        lista.mostrar();

        System.out.println("\nCantidad de nodos: " + lista.cantidad());
        System.out.println("Primer elemento: " + lista.primerElemento());

        // Modificar un valor
        lista.modificarValorEnPosicion(25, 2);  // Modificar posición 2 (era 15)
        System.out.println("\nLista luego de modificar posición 2:");
        lista.mostrar();

        // Verificar pertenencia
        System.out.println("\n¿La lista contiene 20? " + lista.pertenece(20));
        System.out.println("¿La lista contiene 100? " + lista.pertenece(100));

        // Borrar primero y último
        lista.borrarPrimero();
        lista.borrarUltimo();
        System.out.println("\nLista después de borrar primero y último:");
        lista.mostrar();

        // Borrar por valor
        lista.insertarAlFinal(25);
        lista.insertarAlFinal(25);
        lista.borrarConValor(25);
        System.out.println("\nLista después de borrar todos los 25:");
        lista.mostrar();

        // Mostrar valor en posición específica
        try {
            int valor = lista.valorEnPosicion(1);
            System.out.println("\nValor en posición 1: " + valor);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        Agenda agenda = new Agenda();

        agenda.agregar(new Contacto("Juan", "123", "juan@mail.com"))
                .agregar(new Contacto("Ana", "456", "ana@mail.com"))
                .agregar(new Contacto("Luis", "789", "luis@mail.com"));

        agenda.listar();

        System.out.println("Buscando a Ana:");
        Contacto c = agenda.buscar("Ana");
        if (c != null) {
            c.mostrar();
        }

        System.out.println("Eliminando contacto con teléfono 123:");
        agenda.borrar("123");

        agenda.listar();
        System.out.println("Cantidad: " + agenda.cantidad());
        
        
        Agenda agenda1 = new Agenda();
        agenda1.agregar(new Contacto("Ana", "111", "ana@mail.com"));
        agenda1.agregar(new Contacto("Luis", "222", "luis@mail.com"));

        Agenda agenda2 = new Agenda();
        agenda2.agregar(new Contacto("Luis", "333", "luisnuevo@mail.com")); // mismo nombre
        agenda2.agregar(new Contacto("Sofía", "444", "sofia@mail.com"));

        AgendaUtil.unirAgendasSinRepetidos(agenda1, agenda2);

        System.out.println("Agenda combinada:");
        agenda1.listar();
    }

}
