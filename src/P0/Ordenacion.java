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

		for (int i=0; i<datos.length; i++) {
			int k = i; 
			for (int j=i+1; j<datos.length; j++) {
				if (datos[j] < datos[k]) k=j; 
			}
			int aux=datos[i]; datos[i]=datos[k]; datos[k]=aux;
		}			

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

		for (int j=datos.length-1; j>=0; j--) 
			for (int i=0; i<j; i++) {
				if (datos[i]>datos[i+1]) {
				int aux=datos[i]; datos[i]=datos[i+1]; datos[i+1]=aux;
			}
		}

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

		boolean ordenado=false; 
		int j=datos.length-1; 
		while (!ordenado) {
			ordenado=true;
			for (int i=0; i<j; i++) {
				if (datos[i]>datos[i+1]) {
					int aux=datos[i]; datos[i]=datos[i+1]; datos[i+1]=aux;
					ordenado=false;
				}
			}
			j--;
		}

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

		boolean ordenado=false; 
		int gap=datos.length-1;
		if (datos[0]>datos[gap]) {
			int aux=datos[0]; datos[0]=datos[gap]; datos[gap]=aux;
		}
		while (!ordenado || gap>1) {
			if (gap>1) gap=(int) Math.floor(gap/1.3);
			ordenado=true; 
			int i=0;
			while (i+gap < datos.length) {
				if (datos[i]>datos[i+gap]) {
					int aux=datos[i]; datos[i]=datos[i+gap]; datos[i+gap]=aux;
					ordenado=false;
				}
				i++;
			} 
		}

		t2 = System.nanoTime();
		return (t2-t1);
    }





}
