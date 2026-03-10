/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Casillas;
/**
 *
 * @author alelo
 */
public class Casillas {

public static void main(String[] args) {
        
        int[] array = {9,4,8,5,1,10,2,6,7};
        
        int[] nuevoArray = bubbleSort(array);
        
        for(int i : nuevoArray){
            System.out.println(i);
        }
    }
    public static int[] bubbleSort(int[] array){ //Este método recibe un arreglo y lo ordena usando el algoritmo Bubble Sort
        
        int n = array.length; //Aquí se guarda el número total de elementos que tiene el arreglo
        
        for (int i = 0; i < n - 1; i++) { //O(N) Este ciclo recorre el arreglo varias veces desde la primera posición hasta la penúltima
            
            for (int j = 0; j < n - i - 1; j++) { //O(N*N) Este ciclo compara los elementos vecinos dentro del arreglo
                
                //Se revisa si el número actual es mayor que el siguiente
                if (array[j] > array[j + 1]) { //N*N Si el número es más grande que el siguiente, se deben cambiar de lugar
                    int temp = array[j]; //N*N Se guarda temporalmente el valor actual
                    array[j] = array[j + 1]; //N*N El valor siguiente pasa a ocupar la posición actual
                    array[j + 1] = temp; //N*N El valor guardado temporalmente se coloca en la siguiente posición
                }
            }
        }   
        
        return array; //Se regresa el arreglo ya ordenado
        
        //Complejidad aproximada del algoritmo: O(N*N), conocida como complejidad cuadrática
    }
}