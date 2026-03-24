package kuikesorteo;


import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Quicksort {
   
    public static void quicksort(int[] arr, int inicio, int fin) {
        if (inicio < fin) { // // 1

            int pivoteIndice = particion(arr, inicio, fin); // // n

            System.out.println("Pivote índice: " + pivoteIndice +
                    " | Arreglo: " + Arrays.toString(arr));

            quicksort(arr, inicio, pivoteIndice - 1); // // T(n/2)

            quicksort(arr, pivoteIndice + 1, fin); // // T(n/2)
        }
    }

    public static int particion(int[] arr, int inicio, int fin) {

        int pivote = arr[fin]; // // 1

        int i = inicio - 1; // // 1

        for (int j = inicio; j < fin; j++) { // // n

            if (arr[j] <= pivote) { // // n
                i++; // // n

                int temp = arr[i]; // // n
                arr[i] = arr[j];   // // n
                arr[j] = temp;     // // n
            }
        }

        int temp = arr[i + 1]; // // 1
        arr[i + 1] = arr[fin]; // // 1
        arr[fin] = temp;       // // 1

        return i + 1; // // 1
    }
    public static void main(String[] args) {

        int[] numeros = {4, 2, 4, 3, 1, 4};

        System.out.println("Arreglo desordenado: " + Arrays.toString(numeros));

        quicksort(numeros, 0, numeros.length - 1);

        System.out.println("Arreglo ordenado: " + Arrays.toString(numeros));
    }
}
