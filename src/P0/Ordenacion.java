package P0;

/**
 * La clase Ordenacion incorpora un conjunto de métodos estáticos que implementan distintos algoritmos de ordenacion.
 * Dado que estos algoritmos son de tipo "in-situ", la ordenación de los elementos
 * del vector se realiza sobre el propio vector, sin utilizar un vector auxiliar, por lo que el resultado de la ordenación
 * queda almacenado en el parámetro que se pasa en la llamada al método. En cada uno de los métodos se devuelve el tiempo
 * empleado por el algoritmo en realizar la ordenación (en nanosegundos).
 */


public class Ordenacion {


	/**
	 * Aplica el algoritmo de ordenación por Insercion sobre el vector datos.
	 * @return tiempo en ns consumido por el algoritmo
	 * @param datos Vector de datos a ordenar. El resultado del vector ordenado se mantiene en este parámetro
	 */
	public static long insercion(int[] datos){
		long t1,t2;
		t1 = System.nanoTime();

		// CODIGO DEL ALGORITMO DE ORDENACION POR INSERCION
		for (int i=1; i<datos.length; i++) {
			int aux = datos[i];
			int k = i;
			while (k > 0 && datos[k - 1] > aux) {
				datos[k] = datos[k - 1];
				k--;
			}
			datos[k] = aux;
		}

		t2 = System.nanoTime();
	    return (t2-t1);
	}


	/**
	 * Aplica el algoritmo de ordenación por Seleccion sobre el vector datos.
	 * @return tiempo en ns consumido por el algoritmo
	 * @param datos Vector de datos a ordenar. El resultado del vector ordenado se mantiene en este parámetro
	 */
	public static long seleccion(int[] datos){
		long t1,t2;
		t1 = System.nanoTime();

		// INCLUIR EL CODIGO DEL ALGORITMO DE ORDENACION POR SELECCION

		t2 = System.nanoTime();
		return (t2-t1);
	}

	/**
	 * Aplica el algoritmo de ordenación por Burbuja sobre el vector datos.
	 * @return tiempo en ns consumido por el algoritmo
	 * @param datos Vector de datos a ordenar. El resultado del vector ordenado se mantiene en este parámetro
	 */
	public static long burbuja(int[] datos){
		long t1,t2;
		t1 = System.nanoTime();

		// INCLUIR EL CODIGO DEL ALGORITMO DE ORDENACION POR BURBUJA

		t2 = System.nanoTime();
		return (t2-t1);
	}


	/**
	 * Aplica el algoritmo de ordenación por Burbuja Optimizado sobre el vector datos.
	 * @return tiempo en ns consumido por el algoritmo
	 * @param datos Vector de datos a ordenar. El resultado del vector ordenado se mantiene en este parámetro
	 */
	public static long burbujaOptimizado(int[] datos){
		long t1,t2;

		t1 = System.nanoTime();

		// INCLUIR EL CODIGO DEL ALGORITMO DE ORDENACION POR BURBUJA OPTIMIZADO

		t2 = System.nanoTime();
		return (t2-t1);
	}

	/**
	 * Aplica el algoritmo de ordenación CombSort sobre el vector datos.
	 * @return tiempo en ns consumido por el algoritmo
	 * @param datos Vector de datos a ordenar. El resultado del vector ordenado se mantiene en este parámetro
	 */
	public static long combSort(int[] datos) {

		long t1,t2;
		t1 = System.nanoTime();

		// INCLUIR EL CODIGO DEL ALGORITMO DE ORDENACION POR COMBSORT

		t2 = System.nanoTime();
		return (t2-t1);
    }





}
