package TP1.clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ulises
 */
public class AgendaUtil {

    public static void unirAgendasSinRepetidos(Agenda destino, Agenda origen) {
        int cantidadOrigen = origen.cantidad();

        for (int i = 0; i < cantidadOrigen; i++) {
            Contacto c = origen.enPosicion(i);
            // Verificamos si no existe en la agenda destino por nombre
            if (destino.buscar(c.getNombre()) == null) {
                destino.agregar(new Contacto(c.getNombre(), c.getTelefono(), c.getEmail()));
            }
        }
    }
}
