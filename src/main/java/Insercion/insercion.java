/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Insercion;

/**
 *
 * @author Usuario
 */
public class insercion {
    
   public static void insertionSort(int[] arr){
        int n = arr.length;

        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Arreglo original:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Arreglo ordenado:");
        printArray(arr);
    }
}  

