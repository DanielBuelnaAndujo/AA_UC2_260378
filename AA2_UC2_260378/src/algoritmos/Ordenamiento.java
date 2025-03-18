package algoritmos;

/**
 *
 * @author daniel
 */
public class Ordenamiento {
    
    public static void mostrar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print( a[i] + ", ");
        }
    }
    
    /**
     * Metodo de ordenamiento Burbuja.
     * 
     * Precondición: El arreglo debe de ser diferente de null.
     * Postcondición: El arreglo debe de estar ordenado.
     * 
     * @param a El arreglo de enteros a entrar.
     * @param i Va acortando el arreglo
     * @param j Recorre el arreglo
     * @param aux El elemento mayor
     */
    public static void burbuja(int[] a) {
        for (int i = 1; i < a.length; i++) { //1+(n-1+1)+(n-1) = 2n
            for (int j = 0; j < a.length-i; j++) { //n*(1+n+1+n) = 2n^2+2n
                // condicion
                if (a[j]>a[j+1]) { //n*n = n^2
                    // Intercambio
                    int aux = a[j]; //n^2
                    a[j] = a[j+1]; //n^2
                    a[j+1] = aux; //n^2
                }
            }
        }
    } //(2n)+(2n^2+2n)+(n^2)+(n^2)+(n^2) = 5n^2+4n O(n^2)
    
    /**
     * Método de ordenamiento por insercion
     * 
     * Precondición: El arreglo no puede estar vacío.
     * Postcondición: El arreglo debe de estar ordenado.
     * 
     * @param a El arreglo de enteros a entrar.
     * @param key Funciona como auxiliar de la posición i en a.
     * @param i Recorre hacia adelante el arreglo.
     * @param j Recorre hacia atras el arreglo.
     */
    public static void insercion(int [] a) {
        for (int i = 1; i < a.length; i++) { //1+(n-1+1)+(n-1) = 2n
            int key = a[i]; //2n
            int j = i-1; //2n
            while (j>=0 && a[j]>key) { //2n*(n) = 2n^2
                a[j+1] = a[j]; //2n^2
                j--; //2n^2
            }
            a[j+1] = key; //2n
        } // (2n)+(2n)+(2n)+(2n^2)+(2n^2)+(2n^2)+(2n)
          // = 4(2n)+3(2n^2)
          // = (8n)+(6n^2) O(n^2)  
    }
    
    // a.length = 6
    public static void seleccion(int[] a) {
        int n = a.length; //1
        for (int i = 0; i < n-1; i++) { //Nos va a dar la posición del elemento más pequeño del arreglo
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j]<a[minIndex]) {
                    minIndex = j;
                }
            }
            //Intercambio
            int aux = a[minIndex];
            a[minIndex] = a[i];
            a[i] = aux;
        }
    }
}
