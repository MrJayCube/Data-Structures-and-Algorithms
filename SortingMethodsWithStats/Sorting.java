package P4 ;

public class Sorting {
	public static SortingStats stats = new SortingStats();
	public static <E extends Comparable <E>> void selectionSort ( E [] v ) {
		Sorting.stats.reset(); //Reseteamos el número de pasos
		stats.startTimer(); //Llamamos a obtener el tiempo de inicio en SortingStats
		
		if (v.length <= 1) return; //Si el vector contiene uno o menos elementos, no hay valores que ordenar, terminamos.
		
		for (int i = 0; i < v.length-1; i++) {

			int posm = i; //Obtenemos la posición en la que nos encontramos que es hasta el momento, la del mínimo
			E small = v[i]; //Insertamos pues en small, el elemento que identificamos como el mínimo

			for (int j=i+1; j < v.length; j++) {

				if (v[j].compareTo(small)<0){
					small=v[j]; //El elemento más pequeño es ahora aquel que se encuentre en la posición j
					posm = j; //La posición del elemento más pequeño es ahora j
				} //Si el elemento en la posición en que nos encontremos, es más pequeño que el elemento identificado como mínimo, intercambiamos.
				
				stats.setSteps(); //Llamamos a incrementar el número de pasos
			} //Para cada elemento posterior al que nos encontremos

			v[posm]=v[i]; //La posición posm del vector pasa a ser la posición i del vector
			v[i]=small; //La posición i del vector pasa a contener el elemento más pequeño identificado
		
		} //Para cada elemento del vector
		
		stats.stopTimer(); //Llamamos a obtener el tiempo de finalización en SortingStats
		stats.setExecTime(); //Llamamos a calcular el tiempo de ejecución (fin - inicio) en SortingStats
	}

	public static <E extends Comparable <E>> void mergeSort (E[] t ) {
		Sorting.stats.reset(); //Llamamos a resetear estadísticas en SortingStats
		
		if (t.length <= 1) return; //Si el vector contiene uno o menos elementos, ya no podemos dividir más, terminamos la ejecución
		
		stats.startTimer(); //Llamamos a calcular tiempo de inicio
		mergeSortRecursive(t); //Llamamos a mergesort con el nuevo vector
		stats.stopTimer(); //Llamamos a calcular tiempo de finalización
		stats.setExecTime(); //Llamamos a calcular tiempo de ejecución (fin - inicio)
	}
	
	private static <E extends Comparable <E>> void mergeSortRecursive (E[] t) {
		
		/* Pasos previos */
		if (t.length <= 1) return; //Si el vector contiene uno o menos elementos, ya no podemos dividir más, terminamos la ejecución
		int m = t.length / 2; //Obtenemos el tope, el punto por el que debemos dividir
		
		/* Inizialización de vectores */
		E[] u = (E[])new Comparable[m]; //Vector que contendrá la parte izquierda del original/2
		E[] v = (E[])new Comparable[t.length-m]; //Vector que contendrá la parte derecha sobrante del vector original /2, digo sobrante por si la división no es entera
		
		/* Copia de vectores */
		System.arraycopy(t, 0, u, 0, m); //Copiamos el array t en u, desde la posición 0 hasta m, a partir de la posición 0
		System.arraycopy(t, m, v, 0, t.length-m); //Copiamos el array t en u, desde la posición 0 hasta la longitud de t - la longitud de m (por si impar), a partir de la posición m
		
		/* Llamadas recursivas */
		mergeSortRecursive(u); //Llamamos al mismo método con el nuevo vector que contiene la parte izquierda
		mergeSortRecursive(v); //Llamamos al mismo método con el nuevo vector que contiene la parte derecha
		merge(t, u, v); //Meclamos
	}

	private static <E extends Comparable<E>> void merge(E[] t, E[] u, E[] v) {
		
		/* Pasos previos */
		int i = 0; // Contador para u
		int j = 0; // Contador para v
		int k = 0; // Contador para t
		
		/* Mezcla de los vectores u y v en t */
		while (i < u.length && j < v.length) { //Iteramos siempre y cuando ninguno de los dos contadores supere el tamaño de sus respectivos vectores

			if (u[i].compareTo(v[j]) < 0) {
				t[k++] = u[i++];
			} else {
				t[k++] = v[j++];
			} /*si el elemento contenido en la posición i de u, es menor que el elemento contenido en la posición j de v, insertamos el elemento de u, en la posición k del vector t e incrementamos k,
			* si no, insertamos el elemento de v, en la posición k del vector t e incrementamos k
			* */
			
			stats.setSteps(); //Incrementamos número de pasos
		} //Mientras no haya sido rebasado el tamaño del vector u por la variable i y el tamaño del vector v por la variable j, seguimos ejecutando (esto pasará con impares por ejemplo)

		while (i < u.length) t[k++] = u[i++]; //Si los vectores son impares, uno de los dos vectores no habrá sido copiado en su totalidad, será necesario introducir a partir de la posición
		while (j < v.length) t[k++] = v[j++]; //Si los vectores son impares, uno de los dos vectores no habrá sido copiado en su totalidad, será necesario introducir a partir de la posición
	}

	public static <E > String array2str (E[] v) {
		int i = 0;
		String chain = "[ "; //Añadimos a chain "[ "
		while (i < v.length) chain += v[i++] + " "; // Guardamos cada elemento del vector en chain junto a un espacio
		return chain += "]"; //Añadimos a chain "]"
	} // 

	public static <E extends Comparable<E>> void mergeSortSoloUnVector(E v[]) {
		Sorting.stats.reset(); //Reseteamos los pasos en SortingStats
		
		stats.startTimer(); //Llamamos a obtener el tiempo de inicio
		Sorting.mergeSortSoloUnVector(v,0,v.length-1);
		stats.stopTimer(); //Llamamos a obtener tiempo de finalización
		
		stats.setExecTime(); //Llamamos a calcular tiempo de ejecución (fin - inicio)
	}

	private static <E extends Comparable<E>> void mergeSortSoloUnVector(E v[], int st, int end) {
		if(end>st) {
			int middle = (st + end)/2; //Calculamos la posición donde dividir el vector
			mergeSortSoloUnVector(v,st,middle); //Llamada recursiva desde la posición inicial hasta la posición de división para seguir dividiendo el vector
			mergeSortSoloUnVector(v,middle+1,end); //Llamada recursiva desde la posición de división+1 hasta la posición de fin para seguir dividiendo el vector
			mergeSoloUnVector(v,st,middle,end); //Cada división llámara al método mergeSoloUnVector, empezando desde la última llamada donde se cumplirá que !(end>st) para ir ordenandose el vector
		} //Si la posición de fin es la posición de inicio, hemos terminado.
	}

	private static <E extends Comparable<E>> void mergeSoloUnVector(E v[], int st, int middle, int end) {
		
		/* Pasos previos */
		int i=st, // Variable que indicará punto de inicio del vector en su parte izquierda
		j=middle+1, //Variable que indicará punto de inicio del vector en su parte derecha
		k=0; // Posición usada para almacenar en aux y en v

		/*
		* Declaramos vector con el tamaño de la porción que estamos ordenando
		* Por ejemplo, un vector v[1, 4, 2, 0, 5, 3] donde st = 3 y end = 5, 
		* la porción serán los elementos contenidos desde v[3] .. v[5] por 
		* lo tanto el vector auxiliar deberá tener tamaño 2 y sumaremos uno 
		* dado que el vector empieza siempre en 0 */
		E[] aux = (E[]) new Comparable [end - st + 1]; 
		
		while(i <= middle && j <= end) {
			if (v[i].compareTo(v[j]) < 0) {
				aux[k++] = v[i++];
			}else { 
				aux[k++] = v[j++];
			}/* Si el elemento en la posición i de la parte izquierda del vector es 
			  *menor que el elemento en la posición j de lam parte derecha del vector, 
			  *entonces insertamos en aux, en la posición k, el elemento más pequeño 
			  *para cualquiera de los dos escenarios (v[i] < v[j] || v[j] < v[i]*/
			stats.setSteps();
		}  /*Mientras no rebasemos la parte definida como izquierda del vector por 
			*middle con la variable i, ni la parte derecha del vector por end con 
			*la variable j*/

		while (i <= middle) {
			aux[k++] = v[i++]; 
		}/* Mientras no se haya recorrido la parte izquierda en su totalidad,
		  *se agregan los elementos faltantes*/
		
		while (j <= end) {
			aux[k++] = v[j++]; 
		}/* Mientras no se haya recorrido la parte derecha en su totalidad,
		  *se agregan los elementos faltantes*/

		for (k = 0; k < aux.length; k++) {
			v[k + st] = aux[k];
		} /*Insertamos los valores ordenados de la porción en el vector auxiliar, 
		   *en el vector original en las posiciones correspondientes de la porción 
		   *del vector enviada a ordenar.*/
	}
}
