package P4;

public class Main{
	public static void main(String[] args){		
		
		/* Declaración de variables */
		Integer[] original; //Vector que generaremos desordenado
		Integer[] copy; //Copia del vector c, que copiaremos desde c y ordenaremos numRep veces
		int numRep = 10; //Número de repeticiones por algoritmo
		long acumTime = 0; //Tiempo acumulado por algoritmo
		int sizeVector;
		int [] dictionary = {
				20000,50000,100000,200000,
				300000,400000,(int) (Math.random()*200000),
				(int) (Math.random()*200000),2000
		}; //Diccionario de valores a ejecutar
		
		/* Plantilla del programa 
|		 *		 	  |			SelectSort			 |			MergeSort			 |			MergeSort Tipo 2	 |
		 *|	 Size	  |  Steps	Ratio		Time(s)	 | Steps	Ratio		Time(s)	 | Steps	Ratio		Time(s)  |*/
		System.out.printf("|\t  |\t\tSelectSort\t\t |\t\tMergeSort\t\t |\t\tMergeSort Tipo 2\t |\n" +
				"|  Size\t  |  Steps\tRatio\t\tTime(s)\t | Steps\tRatio\t\tTime(s)\t | Steps\tRatio\t\tTime(s)  |\n" +
				"---------------------------------------------------------------------------------------------------------------------------------\n");
		
		for(int pos = 0; pos < dictionary.length; pos++) { //Mientras no se hayan procesado todos los elementos del diccionario
			
			/* Asignación de variables */
			sizeVector = dictionary[pos]; //Variable para almacenar el tamaño del vector
			original = new Integer[sizeVector]; //crear array de enteros del tamaño indicado en la posición p, del diccionario
			copy = new Integer[sizeVector]; //Crear array de enteros para el vector donde copiaremos el original
			Sorting.stats.setSize(sizeVector); //Asignamos en SortingStats el tamaño del vector
			
			/* Rellenado del vector */
			for(int j = 0; j < sizeVector; j++) { 
				original[j] = (int) (Math.random()*2500000);
			} //Generamos los elementos aleatorios contenidos en el vector
			
			/* Plantilla del programa |  [sizeVector]  | */
			System.out.printf(String.format("|  %-7d|",sizeVector));
			for(int numA = 0; numA<3; numA++ ) { //Bucle que delimita el algoritmo a ejecutar
				
				for(int i = 0; i < numRep; i++) { //Bucle que delimita el número de veces a ejecutar por algoritmo
					System.arraycopy(original, 0, copy, 0, sizeVector); //Copiamos el vector original en el vector copy (siempre mantendremos un vector desordenado, mantendremos el coste de copia pero no el de generación de valores aleatorios)
					
					switch(numA) {
						case 0: //En el caso de encontrarnos en numA == 0, se llamará al selectionSort
							Sorting.selectionSort(copy);
							break;
							
						case 1: //En el caso de encontrarnos en numA == 1, se llamará al mergeSort
							Sorting.mergeSort(copy);
							break;
							
						case 2: //En el caso de encontrarnos en numA == 2, se llamará al mergeSortConSoloUnVector
							Sorting.mergeSortSoloUnVector(copy);
							break;
					}
					
					acumTime += Sorting.stats.execTime(); //Sumamos el tiempo de ejecución que nos devuelve la función
				}
				
				/* Plantilla del programa 
				 * | [steps]    [Ratio]            [Time(s)]   |  [steps]    [Ratio]            [Time(s)]   |  [steps]    [Ratio]            [Time(s)]   |  */
				System.out.printf(String.format(" %-13d%-16.0f%-8.3f| ",Sorting.stats.steps(),Sorting.stats.sizeStepsRatio(),acumTime/numRep/1E09));
				acumTime = 0; //Hemos terminado la secuencia de un algoritmo, reseteamos la variable.
			}
			
			System.out.printf("\n"); //Salto de línea
		}
	}
}
