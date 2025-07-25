/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1.clases;

/**
 *
 * @author Ulises
 */
public class Agenda {
    private ListaEnlazadaContacto contactos;

    public Agenda() {
        contactos = new ListaEnlazadaContacto();
    }

    public Agenda agregar(Contacto c) {
        contactos.insertarAlFinal(c);
        return this;
    }

    public Contacto buscar(String nombre) {
        return contactos.buscarPorNombre(nombre);
    }

    public ListaEnlazadaContacto borrar(String telefono) {
        contactos.borrarPorTelefono(telefono);
        return contactos;
    }

    public void listar() {
        contactos.listarContactos();
    }

    public int cantidad() {
        return contactos.cantidad();
    }

    public Contacto enPosicion(int posicion) {
        return contactos.contactoEnPosicion(posicion);
    }
}

