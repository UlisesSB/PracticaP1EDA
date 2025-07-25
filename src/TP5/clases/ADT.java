/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.clases;

/**
 *
 * @author Ulises
 */
public class ADT {

    /*
    1) Teniendo en cuenta el ADT PILA(item):  
    a)  Agregue a la especificación algebraica del mismo la operación FONDO que selecciona el item que se encuentra en el fondo de la pila. 
    b) Teniendo en cuenta las operaciones del ADT PILA(item): PV (Pilavacia), Push, Pop, Top y Fondo indique en función de las constructoras primitivas cuál es el  resultado en las siguientes expresiones: 
    
    a)Sintaxis:
    PV : → PILA (pila vacía)
    Push : PILA × item → PILA
    Pop : PILA → PILA
    Top : PILA → item
    Fondo : PILA → item ⬅️ (nueva operación)

    Semantica: x, y : item, P : PILA
    Top(Push(P, x)) = x
    Pop(Push(P, x)) = P
    
    Fondo(Push(PV, x)) = x
    Fondo(Push(P, x)) = Fondo(P) si P ≠ PV
    
    b)
    i) ec
    ii) k1ba
    iii) 634
    iv) 2
    v) 1731
    
    2) Escriba una implementación en Java del ADT PILA con lista simplemente enlazada. Pruebe todas las operaciones de la Pila. 
    3) Buscar la documentación de la clase Stack del paquete java.util. ¿En qué se diferencia esta implementación con el ADT visto en clase?  
    4) Como usuario del ADT PILA, diseñe un algoritmo para verificar si una expresión matemática tiene balanceado los paréntesis. 
    5) Diseña un sistema que simule el funcionamiento de los botones "Atrás" y "Adelante" de un navegador web utilizando dos pilas para su implementación. 
    Las URLs estarán representadas mediante números enteros. Crea una clase llamada Navegador, que contenga los siguientes métodos: 
    6) Represente con diagramas los estado de la una pila cuando se aplican cada una de las siguientes operaciones de forma consecutiva 
    A. Pila P= Pilavacia 
    B. Push(P, 3) 
    C. Push(Push(P, 6), 2) 
    D. Pop( P ) 
    E. Push(P, Top(p)) 
    F. Push(Pop(Push(Push(Push(Pop(P), 8),5),9)),4) 
    
    7)a)Escriba un algoritmo en términos del ADT PILA para CONVERTIR una expresión aritmética dada en notación infija a una expresión en notación postfija. 
    El proceso de convertir acepta una expresión infija como entrada y produce una expresión postfija como salida. 
    Considere expresiones bien formadas que tengan variables (de la ‘a’ a la ‘z’), operadores binarios (+, -, *, /, ^) y paréntesis. 
    La idea es utilizar una pila para almacenar los operadores a medida que son encontrados para más tarde desapilar estos operadores de acuerdo a su prioridad.
    b)Escriba un algoritmo en términos del ADT PILA (operandos) para EVALUAR una expresión aritmética en notación postfija. 
    
    a) Entrada: expresión infija E como cadena
    Salida: expresión postfija como cadena

    Crear una pila P de operadores
    Crear una cadena de salida S vacía

Para cada símbolo c en E:
    Si c es una letra (operando):
        Agregar c a S
    Si c es '(':
        Push(P, c)
    Si c es ')':
        Mientras Top(P) ≠ '(':
            Agregar Pop(P) a S
        Pop(P)  // eliminar '('
    Si c es un operador (+, -, *, /, ^):
        Mientras P no esté vacía Y precedencia(Top(P)) ≥ precedencia(c):
            Agregar Pop(P) a S
        Push(P, c)

Mientras P no esté vacía:
    Agregar Pop(P) a S

Devolver S

    b) Entrada: expresión postfija E como cadena
    Salida: resultado (número)

    Crear una pila P de enteros

Para cada símbolo c en E:
    Si c es un número u operando con valor (por ejemplo, 'a' = 2):
        Push(P, valor de c)
    Si c es un operador:
        op2 ← Pop(P)
        op1 ← Pop(P)
        resultado ← aplicar(c, op1, op2)
        Push(P, resultado)

Devolver Pop(P)
     */
}
