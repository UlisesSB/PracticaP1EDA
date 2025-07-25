/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.clases;

import java.util.Random;

/**
 *
 * @author Ulises
 */
public class ProductoMatrices {

    /*genera una matriz de orden n con numeros del 0 al 9*/
    public static int[][] generarMatriz(int n) {
        Random rand = new Random();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rand.nextInt(10); // valores entre 0 y 9
            }
        }
        return matriz;
    }

    /*Multiplica las matrices generadas*/
    public static int[][] multiplicarMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] resultado = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int suma = 0;
                for (int k = 0; k < n; k++) {
                    suma += A[i][k] * B[k][j];
                }
                resultado[i][j] = suma;
            }
        }

        return resultado;
    }
}
