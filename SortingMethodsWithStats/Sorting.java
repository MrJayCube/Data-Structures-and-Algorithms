package P4 ;

public class Sorting {
	public static SortingStats stats = new SortingStats();
	public static <E extends Comparable <E>> void selectionSort ( E [] v ) {
		Sorting.stats.reset(); //Reseteamos el n�mero de pasos
		stats.startTimer(); //Llamamos a obtener el tiempo de inicio en SortingStats
		
		if (v.length <= 1) return; //Si el vector contiene uno o menos elementos, no hay valores que ordenar, terminamos.
		
		for (int i = 0; i < v.length-1; i++) {

			int posm = i; //Obtenemos la posici�n en la que nos encontramos que es hasta el momento, la del m�nimo
			E small = v[i]; //Insertamos pues en small, el elemento que identificamos como el m�nimo

			for (int j=i+1; j < v.length; j++) {

				if (v[j].compareTo(small)<0){
					small=v[j]; //El elemento m�s peque�o es ahora aquel que se encuentre en la posici�n j
					posm = j; //La posici�n del elemento m�s peque�o es ahora j
				} //Si el elemento en la posici�n en que nos encontremos, es m�s peque�o que el elemento identificado como m�nimo, intercambiamos.
				
				stats.setSteps(); //Llamamos a incrementar el n�mero de pasos
			} //Para cada elemento posterior al que nos encontremos

			v[posm]=v[i]; //La posici�n posm del vector pasa a ser la posici�n i del vector
			v[i]=small; //La posici�n i del vector pasa a contener el elemento m�s peque�o identificado
		
		} //Para cada elemento del vector
		
		stats.stopTimer(); //Llamamos a obtener el tiempo de finalizaci�n en SortingStats
		stats.setExecTime(); //Llamamos a calcular el tiempo de ejecuci�n (fin - inicio) en SortingStats
	}

	public static <E extends Comparable <E>> void mergeSort (E[] t ) {
		Sorting.stats.reset(); //Llamamos a resetear estad�sticas en SortingStats
		
		if (t.length <= 1) return; //Si el vector contiene uno o menos elementos, ya no podemos dividir m�s, terminamos la ejecuci�n
		
		stats.startTimer(); //Llamamos a calcular tiempo de inicio
		mergeSortRecursive(t); //Llamamos a mergesort con el nuevo vector
		stats.stopTimer(); //Llamamos a calcular tiempo de finalizaci�n
		stats.setExecTime(); //Llamamos a calcular tiempo de ejecuci�n (fin - inicio)
	}
	
	private static <E extends Comparable <E>> void mergeSortRecursive (E[] t) {
		
		/* Pasos previos */
		if (t.length <= 1) return; //Si el vector contiene uno o menos elementos, ya no podemos dividir m�s, terminamos la ejecuci�n
		int m = t.length / 2; //Obtenemos el tope, el punto por el que debemos dividir
		
		/* Inizializaci�n de vectores */
		E[] u = (E[])new Comparable[m]; //Vector que contendr� la parte izquierda del original/2
		E[] v = (E[])new Comparable[t.length-m]; //Vector que contendr� la parte derecha sobrante del vector original /2, digo sobrante por si la divisi�n no es entera
		
		/* Copia de vectores */
		System.arraycopy(t, 0, u, 0, m); //Copiamos el array t en u, desde la posici�n 0 hasta m, a partir de la posici�n 0
		System.arraycopy(t, m, v, 0, t.length-m); //Copiamos el array t en u, desde la posici�n 0 hasta la longitud de t - la longitud de m (por si impar), a partir de la posici�n m
		
		/* Llamadas recursivas */
		mergeSortRecursive(u); //Llamamos al mismo m�todo con el nuevo vector que contiene la parte izquierda
		mergeSortRecursive(v); //Llamamos al mismo m�todo con el nuevo vector que contiene la parte derecha
		merge(t, u, v); //Meclamos
	}

	private static <E extends Comparable<E>> void merge(E[] t, E[] u, E[] v) {
		
		/* Pasos previos */
		int i = 0; // Contador para u
		int j = 0; // Contador para v
		int k = 0; // Contador para t
		
		/* Mezcla de los vectores u y v en t */
		while (i < u.length && j < v.length) { //Iteramos siempre y cuando ninguno de los dos contadores supere el tama�o de sus respectivos vectores

			if (u[i].compareTo(v[j]) < 0) {
				t[k++] = u[i++];
			} else {
				t[k++] = v[j++];
			} /*si el elemento contenido en la posici�n i de u, es menor que el elemento contenido en la posici�n j de v, insertamos el elemento de u, en la posici�n k del vector t e incrementamos k,
			* si no, insertamos el elemento de v, en la posici�n k del vector t e incrementamos k
			* */
			
			stats.setSteps(); //Incrementamos n�mero de pasos
		} //Mientras no haya sido rebasado el tama�o del vector u por la variable i y el tama�o del vector v por la variable j, seguimos ejecutando (esto pasar� con impares por ejemplo)

		while (i < u.length) t[k++] = u[i++]; //Si los vectores son impares, uno de los dos vectores no habr� sido copiado en su totalidad, ser� necesario introducir a partir de la posici�n
		while (j < v.length) t[k++] = v[j++]; //Si los vectores son impares, uno de los dos vectores no habr� sido copiado en su totalidad, ser� necesario introducir a partir de la posici�n
	}

	public static <E > String array2str (E[] v) {
		int i = 0;
		String chain = "[ "; //A�adimos a chain "[ "
		while (i < v.length) chain += v[i++] + " "; // Guardamos cada elemento del vector en chain junto a un espacio
		return chain += "]"; //A�adimos a chain "]"
	} // 

	public static <E extends Comparable<E>> void mergeSortSoloUnVector(E v[]) {
		Sorting.stats.reset(); //Reseteamos los pasos en SortingStats
		
		stats.startTimer(); //Llamamos a obtener el tiempo de inicio
		Sorting.mergeSortSoloUnVector(v,0,v.length-1);
		stats.stopTimer(); //Llamamos a obtener tiempo de finalizaci�n
		
		stats.setExecTime(); //Llamamos a calcular tiempo de ejecuci�n (fin - inicio)
	}

	private static <E extends Comparable<E>> void mergeSortSoloUnVector(E v[], int st, int end) {
		if(end>st) {
			int middle = (st + end)/2; //Calculamos la posici�n donde dividir el vector
			mergeSortSoloUnVector(v,st,middle); //Llamada recursiva desde la posici�n inicial hasta la posici�n de divisi�n para seguir dividiendo el vector
			mergeSortSoloUnVector(v,middle+1,end); //Llamada recursiva desde la posici�n de divisi�n+1 hasta la posici�n de fin para seguir dividiendo el vector
			mergeSoloUnVector(v,st,middle,end); //Cada divisi�n ll�mara al m�todo mergeSoloUnVector, empezando desde la �ltima llamada donde se cumplir� que !(end>st) para ir ordenandose el vector
		} //Si la posici�n de fin es la posici�n de inicio, hemos terminado.
	}

	private static <E extends Comparable<E>> void mergeSoloUnVector(E v[], int st, int middle, int end) {
		
		/* Pasos previos */
		int i=st, // Variable que indicar� punto de inicio del vector en su parte izquierda
		j=middle+1, //Variable que indicar� punto de inicio del vector en su parte derecha
		k=0; // Posici�n usada para almacenar en aux y en v

		/*
		* Declaramos vector con el tama�o de la porci�n que estamos ordenando
		* Por ejemplo, un vector v[1, 4, 2, 0, 5, 3] donde st = 3 y end = 5, 
		* la porci�n ser�n los elementos contenidos desde v[3] .. v[5] por 
		* lo tanto el vector auxiliar deber� tener tama�o 2 y sumaremos uno 
		* dado que el vector empieza siempre en 0 */
		E[] aux = (E[]) new Comparable [end - st + 1]; 
		
		while(i <= middle && j <= end) {
			if (v[i].compareTo(v[j]) < 0) {
				aux[k++] = v[i++];
			}else { 
				aux[k++] = v[j++];
			}/* Si el elemento en la posici�n i de la parte izquierda del vector es 
			  *menor que el elemento en la posici�n j de lam parte derecha del vector, 
			  *entonces insertamos en aux, en la posici�n k, el elemento m�s peque�o 
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
		} /*Insertamos los valores ordenados de la porci�n en el vector auxiliar, 
		   *en el vector original en las posiciones correspondientes de la porci�n 
		   *del vector enviada a ordenar.*/
	}
}
