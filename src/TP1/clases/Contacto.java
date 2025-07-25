/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1.clases;

/**
 *
 * @author Ulises
 */
public class Contacto {

        private String nombre;
        private String telefono;
        private String email;

        public Contacto(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getEmail() {
            return email;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void mostrar() {
            System.out.println("Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email);
        }
    }
