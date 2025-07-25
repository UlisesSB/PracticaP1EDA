/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.clases;

/**
 *
 * @author Ulises
 */
public class Usuario {
    String nombre;
    String apellido;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Usuario)) return false;
        Usuario otro = (Usuario) obj;
        return this.nombre.equals(otro.nombre) && this.apellido.equals(otro.apellido);
    }

    public String toString() {
        return nombre + " " + apellido;
    }
}
