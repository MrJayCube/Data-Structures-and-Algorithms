package P4 ;

public class SortingStats {
	// atributos de clase , publicos o privados
	private int size;
	private long steps = 0;
	private long execTime;
	private long init;
	private long finish;
	
	public int size () {
		return size;
	} // talla del vector
	
	public long steps () {
		return steps;
	} // pasos ejecutados
	
	public float sizeStepsRatio () {
		return this.steps/this.size;
	} // cociente pasos / talla
	
	public long execTime () {
		return execTime;
	
	} // tiempo ejecucion , en nanosegundos
	
 // + metodos publicos usados por los algoritmos de la clase Sorting*/
	
	public void setSteps() { 
		this.steps++; 
	} //Incrementamos el número de pasos
	
	public void setSize(int size) { 
		this.size = size; 
	} //Asignamos el tamaño
	
	public void setExecTime() { 
		this.execTime = this.finish - this.init; 
	} //Calculamos y asignamos el tiempo de ejecución
	
	public void reset() {	
		this.steps = 0; 
	} //Reseteamos el número de pasos
	
	public void startTimer() { 
		this.init = System.nanoTime(); 
	} //Capturamos el tiempo de inicio y lo asignamos a init
	
	public void stopTimer() { 
		this.finish = System.nanoTime(); 
	} //Capturamos el tiempo de finalización y lo asignamos a finish
}