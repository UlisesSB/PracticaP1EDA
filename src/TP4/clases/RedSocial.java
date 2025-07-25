/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.clases;

/**
 *
 * @author Ulises
 */
public class RedSocial {

    /*
4) Considere el ADT REDSOCIAL(USUARIO) definido con las siguientes operaciones: 
    Sintaxis: 
    REDSOCIALVACIA:     → REDSOCIAL
    REGISTRAR:          REDSOCIAL x USUARIO → REDSOCIAL
    ESVACIA:            REDSOCIAL → BOOL
    ESTA:               REDSOCIAL x USUARIO → BOOL
    ECHAR:              REDSOCIAL x USUARIO → REDSOCIAL
    ULTIMOUSUARIO:      REDSOCIAL → USUARIO U {indefinido}
    CANTIDAD:           REDSOCIAL → ENTERO  ≥ 0 
    Semántica: Para todo R ∈ REDSOCIAL, para todo u, v ∈ USUARIO. 
    ESVACIA(REDSOCIALVACIA)  ≡  TRUE 
    ESVACIA(REGISTRAR(A,u))  ≡  FALSE 
    
    ESTA(REDSOCIALVACIA,u)   ≡  FALSE 
    ESTA(REGISTRAR(A,u),v)   ≡  u = v OR ESTA(A , v) 
    ECHAR(REDSOCIALVACIA,u)  ≡  REDSOCIALVACIA 
    ECHAR(REGISTRAR(R,u), v) ≡  SI u=v entonces  
                                    ECHAR(R,v) 
                                SINO REGISTRAR(ECHAR(R,v),u) 
    
    ULTIMOUSUARIO(REDSOCIALVACIA) ≡ indefinido 
    ULTIMOUSUARIO(REGISTRAR(A,u)) ≡ u 
    CANTIDAD(REDSOCIALVACIA)      ≡ 0 
    CANTIDAD(REGISTRAR(R,u))      ≡ 1 + CANTIDAD(R) 
    
    a) Dado el ADT REDSOCIAL agregue a la especificación algebraica la siguiente operación: 
    esAmigoComun: recibe 2 redes sociales y un usuario, determinando si el mismo pertenece a ambas. En ese caso debe retornar true. 
    b) Implemente en Java el ADT REDSOCIAL(USUARIOS) usando lista simplemente enlazada. USUARIO debe contener los atributos nombre, apellido. 
    La implementación de la operación ESTA debe ser recursiva. 
    c) Como usuario del ADT REDSOCIAL escriba una Función UNION que dadas 2 REDESSOCIALES le devuelva otra REDSOCIAL, armada con todos los ítems de las dos redes dadas. 
    d) Escriba un programa de prueba que construya objetos de la clase REDSOCIAL y aplique todas las operaciones y la función del punto b). 
     */

    //a)
    /*Sintaxis: esAmigoComun : REDSOCIAL × REDSOCIAL × USUARIO → Bool
    Semántica: Para redes sociales R1, R2 y usuario u:
    esAmigoComun(R1, R2, u) ≡ ESTA(R1, u) ∧ ESTA(R2, u)*/
    
    //b)
    private Nodo cabeza;

    public RedSocial() {
        cabeza = null;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void registrar(Usuario u) {
        if (!esta(u)) {
            Nodo nuevo = new Nodo(u);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }

    public boolean esta(Usuario u) {
        return estaRecursivo(cabeza, u);
    }

    private boolean estaRecursivo(Nodo nodo, Usuario u) {
        if (nodo == null) {
            return false;
        }
        if (nodo.usuario.equals(u)) {
            return true;
        }
        return estaRecursivo(nodo.siguiente, u);
    }

    public void echar(Usuario u) {
        cabeza = echarRecursivo(cabeza, u);
    }

    private Nodo echarRecursivo(Nodo nodo, Usuario u) {
        if (nodo == null) {
            return null;
        }
        if (nodo.usuario.equals(u)) {
            return echarRecursivo(nodo.siguiente, u);
        }
        nodo.siguiente = echarRecursivo(nodo.siguiente, u);
        return nodo;
    }

    public Usuario ultimoUsuario() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.usuario;
    }

    public int cantidad() {
        return cantidadRecursiva(cabeza);
    }

    private int cantidadRecursiva(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + cantidadRecursiva(nodo.siguiente);
    }

    public static boolean esAmigoComun(RedSocial r1, RedSocial r2, Usuario u) {
        return r1.esta(u) && r2.esta(u);
    }

    public void mostrar() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.println(aux.usuario);
            aux = aux.siguiente;
        }
    }
    
    public static RedSocial union(RedSocial r1, RedSocial r2) {
    RedSocial nueva = new RedSocial();

    // Agregar todos los usuarios de r1
    Nodo aux = r1.cabeza;
    while (aux != null) {
        nueva.registrar(aux.usuario);
        aux = aux.siguiente;
    }

    // Agregar usuarios de r2 que no estén ya
    aux = r2.cabeza;
    while (aux != null) {
        nueva.registrar(aux.usuario);
        aux = aux.siguiente;
    }

    return nueva;
}
}
