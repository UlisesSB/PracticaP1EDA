/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.clases;

/**
 *
 * @author Ulises
 */
public class Especificaciones {
    /*
    1) Sea el tipo abstracto de datos CADENA visto en clases, agregue a la especificación algebraica, las siguientes operaciones: 
    • Operación que determine la presencia o no de un carácter dado. 
    • Operación que determine si dos cadenas son iguales. 
    • Selectora del primer caracter de la cadena. 
    • Borrar el primer caracter de la cadena. 
    • Reemplazar todas las ocurrencias de un determinado caracter por otro. 
    • Test para determinar si un caracter pertenece a la cadena. 
    
    SINTAXIS CADENA 
    vacía : → Cadena
    agregar : Caracter × Cadena → Cadena
    contiene : Caracter × Cadena → Bool                     Devuelve verdadero si el carácter está en la cadena, falso en caso contrario.
    igual : Cadena × Cadena → Bool                          Devuelve verdadero si ambas cadenas son exactamente iguales.
    primero : Cadena → Caracter                             Devuelve el primer carácter de la cadena.
    borrar : Cadena → Cadena                                Devuelve la cadena sin su primer carácter.
    reemplazar : Caracter × Caracter × Cadena → Cadena      Reemplaza todas las apariciones del primer carácter por el segundo en la cadena.
    
    SEMANTICA: c, c1, c2 : Caracter, s : Cadena
    primero(agregar(c, s)) = c
    
    borrar(agregar(c, s)) = s

    contiene(c, vacía) = false
    contiene(c, agregar(c, s)) = true
    contiene(c, agregar(c1, s)) = contiene(c, s) (si c ≠ c1)
    
    igual(vacía, vacía) = true
    igual(agregar(c1, s), vacía) = false
    igual(vacía, agregar(c1, s)) = false
    igual(agregar(c1, s), agregar(c2, s2)) = (c1 = c2) ∧ igual(s, s2)

    reemplazar(c1, c2, vacía) = vacía
    reemplazar(c1, c2, agregar(c1, s)) = agregar(c2, reemplazar(c1, c2, s))
    reemplazar(c1, c2, agregar(c, s)) = agregar(c, reemplazar(c1, c2, s)) (si c ≠ c1)
    
    ---------------------------------------------------------------------------------------------------------------------------------------------
    
    2) Teniendo en cuenta las operaciones del ADT CADENA: NULA (CN), PRIMERCAR (Pr), AGCAR (Ag), BORRAR (B), REEMPLAZAR(Reemp) y CONCAT(Concat), 
    indique en función de las constructoras cuál es la cadena resultante en las siguientes expresiones: 
    a. Ag( B( Ag( B(Ag( Ag( Ag( CN, a), b), c)),a)), d)                                                     dba
    b. Ag( Reemp( Ag( B(Ag( Ag( Ag( CN, a), b), c)),a) , a, h), a)                                          ahbh
    c. Concat( B( Ag( Ag(CN,a),b)), Ag( Ag(CN,c), Pr( Ag( B( Ag( Ag(CN,e), f),g) )) ) )                     afc
    
    ---------------------------------------------------------------------------------------------------------------------------------------------
    
    3)3) Se necesita administrar información de playlists. Los datos que se necesitan de cada uno son: 
    Se solicita crear un TAD PLAYLIST(CANCION) que permita realizar las siguientes operaciones: 
    ● Crear una Playlist vacía 
    ● Dada una Playlist, añadir una canción 
    ● Indicar si la playlist está vacía o no. 
    ● Eliminar una canciones de la playlist 
    ● Eliminar la última canción agregada 
    ● Retornar la cantidad de canciones en la playlist. 
    ● Indicar si una canción está en la Playlist 
    A - Escriba sintaxis y semántica de cada operación. 
    B - Como usuario del ADT Playlist, escriba una función que dada dos Playlist L1 y L2, devuelva una nueva playlist con las canciones en comunes a L1 y L2. 
    
    A)
    SEMANTICA PLAYLIST
    crearPlaylist : → Playlist
    añadir : Cancion × Playlist → Playlist
    esVacia : Playlist → Bool
    eliminar : Cancion × Playlist → Playlist
    eliminarUltima : Playlist → Playlist
    cantidad : Playlist → Nat
    contiene : Cancion × Playlist → Bool
    
    SEMANTICA: c, c1 : Cancion, p : Playlist
    esVacia(crearPlaylist) = true
    esVacia(añadir(c, p)) = false

    cantidad(crearPlaylist) = 0
    cantidad(añadir(c, p)) = 1 + cantidad(p)

    eliminarUltima(añadir(c, p)) = p

    contiene(c, crearPlaylist) = false
    contiene(c, añadir(c, p)) = true
    contiene(c, añadir(c1, p)) = contiene(c, p) si c ≠ c1

    eliminar(c, crearPlaylist) = crearPlaylist
    eliminar(c, añadir(c, p)) = eliminar(c, p)
    eliminar(c, añadir(c1, p)) = añadir(c1, eliminar(c, p)) si c ≠ c1
    
    B)
    FUNCION cancionesEnComun(L1: Playlist, L2: Playlist): Playlist
    nueva ← crearPlaylist()

    mientras no esVacia(L1) hacer
        c ← obtenerPrimeraCancion(L1)
        si contiene(c, L2) y no contiene(c, nueva) entonces
            nueva ← añadir(c, nueva)
        fin si
    L1 ← eliminarUltima(L1)
    fin mientras

    retornar nueva
    fin func

    ---------------------------------------------------------------------------------------------------------------------------------------------
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    */
}
