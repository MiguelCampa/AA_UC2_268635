/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elecciones;

/**
 *
 * @author Usuario
 */
public class Selecciones {
        
    
public static void main(String[] args) {
        
        // Arreglo de ejemplo que será ordenado
        int[] arr = {7, 3, 9, 2, 5, 1, 8}; // 1
    
        
        // Se llama al método de ordenación por selección
        selectionSort(arr);// 1
        
        // Se imprime el arreglo ya ordenado
        System.out.println("Arreglo ordenado:");// 1
        for(int i : arr){// n
            System.out.println(i);// n
        }
    }
    
    // Método de ordenación por selección
    // Este algoritmo busca el elemento más pequeño del arreglo
    // y lo coloca en la posición correcta, repitiendo el proceso
    // hasta que todos los elementos quedan ordenados
    public static void selectionSort(int[] arr) {
        
        int n = arr.length; // cantidad de elementos en el arreglo
        
             // Recorre el arreglo dejando la parte izquierda ya ordenada
        for (int i = 0; i < n - 1; i++){// n
            
            int indiceMinimo = i; // n
            // se asume que el elemento actual es el menor
            
            // Se busca el valor más pequeño en la parte restante del arreglo
            for (int j = i + 1; j < n; j++){ // 2n
                if (arr[j] < arr[indiceMinimo]){ // 2n
                    indiceMinimo = j;  // 2n
                    // se actualiza la posición del menor encontrado
                }
            }
            
            // Se intercambia el valor mínimo encontrado con el valor actual
            int aux = arr[indiceMinimo];// n
            arr[indiceMinimo] = arr[i];// n
            arr[i] = aux;// n
        }
    }
}