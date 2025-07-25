/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.clases;

/**
 *
 * @author Ulises
 */
public class Nodo {
    Usuario usuario;
    Nodo siguiente;

    Nodo(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
    }
}
