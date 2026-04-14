/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megasort;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class MergeSort {
    

    /**
     * Método principal que divide el arreglo
     * 
     * Complejidad:
     * // n log n
     */
    public static void sort(int[] array) {

        if (array.length < 2) { // 1
            return; // Caso base
        }

        int medio = array.length / 2;  // 1

        int[] izquierda = new int[medio];  // n/2
        int[] derecha = new int[array.length - medio];  // n/2

        // Llenar subarreglo izquierdo
        for (int i = 0; i < medio; i++) {  // n/2
            izquierda[i] = array[i];
        }

        // Llenar subarreglo derecho
        for (int i = medio; i < array.length; i++) { // n/2
            derecha[i - medio] = array[i];
        }

        // Llamadas recursivas
        sort(izquierda);  // T(n/2)
        sort(derecha);    // T(n/2)

        // Mezclar resultados
        merge(array, izquierda, derecha);  // n
    }

    private static void merge(int[] array, int[] izquierda, int[] derecha) {

        int i = 0, j = 0, k = 0;  // 1

        // Comparar y mezclar
        while (i < izquierda.length && j < derecha.length) {  // n
            if (izquierda[i] <= derecha[j]) {  // n
                array[k++] = izquierda[i++]; // n
            } else {
                array[k++] = derecha[j++]; // n
            }
        }

        // Copiar sobrantes izquierda
        while (i < izquierda.length) { // n/2
            array[k++] = izquierda[i++];
        }

        // Copiar sobrantes derecha
        while (j < derecha.length) { // n/2
            array[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Arreglo desordenado: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }
}