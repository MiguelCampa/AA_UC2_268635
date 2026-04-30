/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts;

// Nodo
class Nodo {
    int valor;
    Nodo izq;
    Nodo der;

    public Nodo(int valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
}

public class BTS {

    Nodo raiz;

    // INSERTAR
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) return new Nodo(valor);

        if (valor < actual.valor)
            actual.izq = insertarRecursivo(actual.izq, valor);
        else if (valor > actual.valor)
            actual.der = insertarRecursivo(actual.der, valor);

        return actual;
    }

    // BUSCAR
    public boolean buscar(int clave) {
        return buscarRecursivo(raiz, clave);
    }

    private boolean buscarRecursivo(Nodo actual, int clave) {
        if (actual == null) return false;
        if (clave == actual.valor) return true;

        return (clave < actual.valor)
                ? buscarRecursivo(actual.izq, clave)
                : buscarRecursivo(actual.der, clave);
    }

    // ELIMINAR
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) return null;

        if (valor < actual.valor) {
            actual.izq = eliminarRecursivo(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = eliminarRecursivo(actual.der, valor);
        } else {

            // Caso 1
            if (actual.izq == null && actual.der == null) return null;

            // Caso 2
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;

            // Caso 3 (sucesor)
            int sucesor = encontrarMinimo(actual.der);
            actual.valor = sucesor;
            actual.der = eliminarRecursivo(actual.der, sucesor);
        }

        return actual;
    }

    private int encontrarMinimo(Nodo actual) {
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.valor;
    }

    // INORDER
    public void inorder() {
        inorderRecursivo(raiz);
    }

    private void inorderRecursivo(Nodo actual) {
        if (actual != null) {
            inorderRecursivo(actual.izq);
            System.out.print(actual.valor + " ");
            inorderRecursivo(actual.der);
        }
    }

    //  IMPRESIÓN VISUAL DEL ÁRBOL (LO QUE QUIERES)
    public void imprimirArbol() {
        imprimirArbolJerarquico(raiz, 0);
    }

    private void imprimirArbolJerarquico(Nodo actual, int nivel) {
        if (actual == null) return;

        imprimirArbolJerarquico(actual.der, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("|\t");
        }

        System.out.println("|----" + actual.valor);

        imprimirArbolJerarquico(actual.izq, nivel + 1);
    }

    // MAIN
    public static void main(String[] args) {

        BTS arbol = new BTS();

        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        System.out.println("Insertando valores en el arbol:");
        for (int v : valores) {
            System.out.print(v + " ");
            arbol.insertar(v);
        }

        System.out.println("\n\nEstructura del arbol:");
        arbol.imprimirArbol();

        // Inorden antes
        System.out.print("\nInorden antes: ");
        arbol.inorder();
        System.out.println();

        System.out.println("\n-----------");

        // Eliminar 50
        arbol.eliminar(50);

        System.out.println("Arbol despues de eliminar 50:");
        arbol.imprimirArbol();

        // Inorden después
        System.out.print("\nInorden después: ");
        arbol.inorder();
        System.out.println();

        // Búsquedas
        System.out.println("\nBusqueda:");
        int[] busquedas = {30, 50, 60};

        for (int b : busquedas) {
            if (arbol.buscar(b))
                System.out.println(b + " encontrado");
            else
                System.out.println(b + " NO encontrado");
        }
    }
}