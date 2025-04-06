package algoritmos;

/**
 *
 * @author daniel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] b = {10, 20, 11, 12, 13};
        //Ordenamiento.insercion(a);
        int[] a = {5, 1, 3};
        int[] c = {12, 20, 11, 13, 10};
        int[] d = {7, 8, 3, 1, 2, 9, 4};
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        int n = a.length;
//        Ordenamiento.quickSort(d, 0, n-1);
//        quickSort(a, 0, n-1);
//        Ordenamiento.mostrar(a);
//        ciclos(new int[4]);
        prueba(b);
    }
    
    public static void prueba(int[] a) {
        for (int i = 1; i < a.length; i++) {
            System.out.println("AA: " + i);
            for (int j = 0; j < a.length-i; j++) {
                System.out.println(j);   
            }
        }
    }
    
    public static void ciclos(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            System.out.println("AA: " + i);
            for (int j = i+1; j < n; j++) {
                System.out.println(j);
            }
        }
    }
    
    public static void seleccion(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
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
