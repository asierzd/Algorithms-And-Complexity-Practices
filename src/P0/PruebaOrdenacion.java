package P0;

import java.util.Random;

/**
 * La clase PruebaOrdenacion se encarga de probar todos y cada uno de los algoritmos de ordenacion in-situ implementados en la clase
 * Ordenacion. Cada algoritmo de ordenación se aplica a un vector con 8 valores enteros concretos y a uno con el número de elementos
 * que indique el usuario inicializadas aleatoriamante
 */

public class PruebaOrdenacion {


    /**
     * Este constructor se encarga de realizar las pruebas de ordenacion de todos los métodos sobre un vector concreto
     */
    public PruebaOrdenacion(){

        // Se crea un vector de Items concreto (ver creaVectorConcreto)
        int[] vectorConcreto = creaVectorConcreto();

        pruebaAlgoritmos(vectorConcreto);
    }

    /**
     * Este constructor se encarga de realizar las pruebas de ordenacion de todos los métodos sobre un vector de valores aleatorios
     * @param tamanioAleatorio Tamaño del vector de int aleatorios con el que se desea realizar las pruebas
     */
    public PruebaOrdenacion(int tamanioAleatorio){

        // Se crea un vector de int aleatorio (ver creaVectorAleatorio)
        int[] vectorAleatorio = creaVectorAleatorio(tamanioAleatorio);

        pruebaAlgoritmos(vectorAleatorio);
    }

    /**
     * Este método permite crear un vector de int con los valores {1, 2, 3, 9, 5, 6, 7, 8}
     */
    private int[] creaVectorConcreto(){
        int[] vector = new int[8];
        vector[0] = 1;
        vector[1] = 2;
        vector[2] = 3;
        vector[3] = 9;
        vector[4] = 5;
        vector[5] = 6;
        vector[6] = 7;
        vector[7] = 8;
        return vector;
    }

    /**
     * Este método permite crear un vector de int con el tamaño que se indique como parámetro,
     * e inicializa todas sus posiciones con valores aleatorios.
     * @param tamanio Entero que indicará el tamaño del vector a crear
     */
    private int[] creaVectorAleatorio(int tamanio){
        Random generador = new Random();

        int[] vector = new int[tamanio];
        for (int i=0;i < tamanio; i++) {
            vector[i] = 10 + generador.nextInt(9*tamanio);
        }
        return vector;
    }

    /**
     * Este método se encarga de aplicar los 5 algoritmos de ordenacion al vector que se pasa como parametro. Al final del metodo
     * se vuelca por consola una tabla resumen con los tiempos consumidos por cada algoritmo de ordenacion
     * @param vector Vector de int sin ordenar
     */
    private void pruebaAlgoritmos(int[] vector){
        long tiempos[] = new long[5];
        tiempos[0] = pruebaInsercion(vector);
        tiempos[1] = pruebaSeleccion(vector);
        tiempos[2] = pruebaBurbuja(vector);
        tiempos[3] = pruebaBurbujaOptimizado(vector);
        tiempos[4] = pruebaCombSort(vector);
        generarResumenTiempos(tiempos);
    }

    /**
     * Aplica el algoritmo de ordenacion por insercion
     * @param vectorDesordenado Vector de int a ordenar
     * @return tiempo en nanosegundos consumido por el algoritmo
     */
    private long pruebaInsercion(int[] vectorDesordenado){
        int[] vector;
        long t;

        // PRUEBA DEL ALGORITMO DE ORDENACION POR INSERCION
        //Por cada ordenación hay que clonar el vector original dado que los métodos de ordenación son in situ
        vector = clonaVector(vectorDesordenado);
        trazaCabecera("INSERCION.", vector);

        t=Ordenacion.insercion(vector);

        trazaCierre(vector, t);
        return t;
    }



    /**
     * Aplica el algoritmo de ordenacion por seleccion
     * @param vectorDesordenado Vector de int a ordenar
     * @return tiempo en nanosegundos consumido por el algoritmo
     */
    private long pruebaSeleccion(int[] vectorDesordenado){
        int[] vector;
        long t;

        // PRUEBA DEL ALGORITMO DE ORDENACION POR SELECCION
        //Por cada ordenación hay que clonar el vector original dado que los métodos de ordenación son in situ
        vector = clonaVector(vectorDesordenado);
        trazaCabecera("SELECCION.", vector);

        t=Ordenacion.seleccion(vector);

        trazaCierre(vector, t);
        return t;
    }

    /**
     * Aplica el algoritmo de ordenacion por  burbuja
     * @param vectorDesordenado Vector de int a ordenar
     * @return tiempo en nanosegundos consumido por el algoritmo
     */
    private long pruebaBurbuja(int[] vectorDesordenado){
        int[] vector;
        long t;

        // PRUEBA DEL ALGORITMO DE ORDENACION POR  BURBUJA
        //Por cada ordenación hay que clonar el vector original dado que los métodos de ordenación son in situ
        vector = clonaVector(vectorDesordenado);
        trazaCabecera("BURBUJA.", vector);

        t=Ordenacion.burbuja(vector);

        trazaCierre(vector, t);
        return t;
    }

    /**
     * Aplica el algoritmo de ordenacion por burbuja optimizado
     * @param vectorDesordenado Vector de int a ordenar
     * @return tiempo en nanosegundos consumido por el algoritmo
     */
    private long pruebaBurbujaOptimizado(int[] vectorDesordenado){
        int[] vector;
        long t;

        // PRUEBA DEL ALGORITMO DE ORDENACION POR BURBUJA OPTIMIZADO
        //Por cada ordenación hay que clonar el vector original dado que los métodos de ordenación son in situ
        vector = clonaVector(vectorDesordenado);
        trazaCabecera("BURBUJA OPTIMIZADO.", vector);

        t=Ordenacion.burbujaOptimizado(vector);

        trazaCierre(vector, t);
        return t;
    }

    /**
     * Aplica el algoritmo de ordenacion combSort
     * @param vectorDesordenado Vector de int a ordenar
     * @return tiempo en nanosegundos consumido por el algoritmo
     */
    private long pruebaCombSort(int[] vectorDesordenado){
        int[] vector;
        long t;

        // PRUEBA DEL ALGORITMO DE ORDENACION COMBSORT
        //Por cada ordenación hay que clonar el vector original dado que los métodos de ordenación son in situ
        vector = clonaVector(vectorDesordenado);
        trazaCabecera("COMBSORT.", vector);

        t=Ordenacion.combSort(vector);

        trazaCierre(vector, t);
        return t;
    }

    /**
     * Vuelca por consola el contenido del vector de datos
     * @param datos Vector de int cuyo contenido se vuelca por consola
     */
    public void imprimirClavesVector(int[] datos){
        for(int i=0; i<datos.length; i++){
            if(i>0) System.out.print(", ");
            System.out.print(datos[i]);
        }
        System.out.println();
    }

    /**
     * Vuelca por pantalla la cabecera del algoritmo a aplicar y el vector a ordenar
     * @param metodo Cadena de caracteres que contendrá el nombre del algoritmo a aplicar
     * @param vector Vector de int a ordenar
     */
    private void trazaCabecera(String metodo, int[] vector){
        System.out.println("----------------------------------");
        System.out.println(metodo);
        System.out.println("----------------------------------");
        System.out.print("Claves del vector antes de ordenar:   ");
        imprimirClavesVector(vector);
    }

    /**
     * Vuelca por pantalla la traza final del algoritmo una vez aplicado
     * @param vector Vector de int ordenados
     * @param t Tiempo consumido por el algoritmo en ordenar los datos del vector
     */
    private void trazaCierre(int[] vector, double t){
        System.out.print("Claves del vector despues de ordenar: ");
        imprimirClavesVector(vector);
        System.out.println("Ordenación realizada en " + t + " [ns]");
        System.out.println();
    }

    /**
     * Vuelca por consola la tabla de tiempos que se pasa como parámetro
     * @param tiempos Vector que contendrá los tiempos de ejecucion de los 5 algoritmos de ordenacion
     */
    private void generarResumenTiempos(long[] tiempos){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("RESUMEN DE TIEMPOS DE EJECUCION DE LOS 5 ALGORITMOS DE ORDENACION");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Insercion       Seleccion       Burbuja         BurbujaOPt      CombSort");
        System.out.println("---------------------------------------------------------------------------------------");
        for (long t: tiempos){
            System.out.print(t / 10E6);
            for (int j = Double.toString((t/10E6)).length(); j < 16; j++) {
                System.out.print(" ");
            }
        }
        System.out.println("[miliseg]");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();

    }

    /**
     * Dado el vector de int que se pasa como parámetro, este método se encarga de hacer una copia independiente del mismo
     * en otro vector de int.
     * @param vector a clonar
     * @return copia independiente del vector que se pasa como parámetro
     */
    private int[] clonaVector(int[] vector){
        int[] nuevoVector = new int[vector.length];
        System.arraycopy(vector, 0, nuevoVector, 0, vector.length);
        return nuevoVector;
    }


    public static void main(String[] args){

        new PruebaOrdenacion();
        new PruebaOrdenacion(100);
    }
}
