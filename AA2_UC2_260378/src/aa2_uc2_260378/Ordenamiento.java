package aa2_uc2_260378;

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
    
    public static void insercion(int [] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i-1;
            while (j>=0 && a[j]>key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }
    
}
