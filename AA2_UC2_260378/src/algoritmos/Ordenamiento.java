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
            for (int j = 0; j < a.length-i; j++) { //(n-1)*((1)+(n-i+1)+(n-i)) = (n-1)*(2n-2i+2) = (2n^2 - 2ni + 2n) - (2n-2i+2) = 2n^2-2ni+2i-2
                // condicion
                if (a[j]>a[j+1]) { //(n-i)*1 = n-i
                    // Intercambio
                    int aux = a[j]; //(n-i)*1 = n-i
                    a[j] = a[j+1]; //(n-i)*2 = 2n-2i
                    a[j+1] = aux; //(n-i)*2 = 2n-2i
                }
            }
        }
    } //(2n)+(2n^2-2ni+2i-2)+2(n-i)+2(2n-2i) = (2n)+(2n^2-2ni+2i-2)+(2n-2i)+(4n-4i) = 2n^2-2ni+8n-4i-2
      //O(n^2)
    
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
            int j = i-1; //2n+1
            while (j>=0 && a[j]>key) { //2n*(n) = 2n^2
                a[j+1] = a[j]; //2n^2
                j--; //2n^2
            }
            a[j+1] = key; //2n+1
        } 
    } // (2n)+(2n)+(2n)+(2n^2)+(2n^2)+(2n^2)+(2n)
      // = 4(2n)+3(2n^2)
      // = (8n)+(6n^2) O(n^2)  
    
    // a.length = 6
    /**
     * Método de ordenamiento por selección
     * 
     * Precondición: El arreglo no puede estar vacío.
     * Postcondición: El arreglo debe de estar ordenado.
     * 
     * @param a El arreglo de enteros a entrar.
     * @param n El tamaño del arreglo
     * @param minIndex El indice del número menor.
     * @param aux Funciona como auxiliar para el valor de a[miniIndex].
     * @param i Recorre cada valor del arreglo y se compara con j.
     * @param j Recorre cada valor del arreglo y se compara con i.
     */
    public static void seleccion(int[] a) {
        int n = a.length; //1
        for (int i = 0; i < n-1; i++) { //2n   Nos va a dar la posición del elemento más pequeño del arreglo
            int minIndex = i; //2n(1) = 2n 
            for (int j = i+1; j < n; j++) { //n((1)+(n-i+1+1)+(n-i+1)) = n(2n-2i+4) = 2n^2-2i+4
                if (a[j]<a[minIndex]) { //(n-i+1)*(1) = n-i+1
                    minIndex = j; //(n-i+1)*(1) = n-i+1
                }
            }
            //Intercambio
            int aux = a[minIndex]; //(n-1)*(1) = n-1
            a[minIndex] = a[i]; //(n-1)*(1) = n-1
            a[i] = aux; //(n-1)*(1) = n-1
        }
    } //(1)+2(2n)+(2n^2-2i+4)+2(n-i+1)+3(n-1) = (4n)+(2n^2-2i+4)+(2n-2i+2)+(3n-3) = 2n^2+9n-4i+3
      //O(n^2)
    
    /**
     * Método de ordenamiento quickSort
     * 
     * Precondición: Las variables a, desde y hasta no pueden estar vacíos.
     * Postcondición: El arreglo debe de estar ordenado.
     * 
     * @param a El arreglo de enteros a entrar.
     * @param desde El inicio del arreglo.
     * @param hasta El final del arreglo.
     * @param pivote La mitad del arreglo en su mayoria.
     */
    public static void quickSort(int[] a, int desde, int hasta) {
        //Caso base
        if (desde<hasta) { //1
        //Caso Recursivo
            //Obtener pivote
            ////lo necesito en cada particion
            int pivote = particionar(a, desde, hasta); //1 op
            //aplicar algoritmo en el segmento de la izquierda
            quickSort(a, desde, pivote-1); //1

            //aplicar algoritmo en el segmento de la derecha
            quickSort(a, pivote+1, hasta); //1
        }
    } 
    // O(nLogn)
    
    /**
     * Metodo para particionar y devolver el indice del pivote
     * 
     * Precondición: Las variables a, desde y hasta no pueden estar vacíos.
     * Postcondición: Un número entero positivo.
     * 
     * @param a El arreglo de enteros a entrar.
     * @param desde El inicio del arreglo.
     * @param hasta El final del arreglo.
     * @param pivote El valor con el que se comparan los demas valores del arreglo.
     * @param i Sirve para intercambiar valores con j y aumenta de 1 en 1.
     * @param j Recorre el arreglo y se compara con i.
     * @param aux Guarda el valor de a[i].
     * @param temp Guarda el valor de a[i+1].
     */
    public static int particionar(int[] a, int desde, int hasta) {
        //seleccionar el pivote
        int pivote = a[hasta]; //1
        //seleccionar el indice mas pequeño
        int i = desde-1; //** //2
        
        //recorrer todo el arreglo buscando elementos menores al pivote
        //para intercambiarlos
        for (int j = desde; j < hasta; j++) {
            //a[j] marca el valor actual con el que se compara el pivote
            if (a[j] < pivote) {
                i++;
                int aux = a[i]; //1
                a[i]=a[j]; //1
                a[j]=aux; //1
            }
        }
        //ultimo intercambio para colocar el pivote
        int temp = a[i+1]; //2
        a[i+1] = a[hasta]; //2
        a[hasta] = temp; //1
        
        //regresar el inicio del pivote
        return i+1; //1
    }
    
    //nLog n
    //n es el numero de veces que se selecciona el pivote y
    //Log n son las particiones de mitad en mitad que hacemos
}
