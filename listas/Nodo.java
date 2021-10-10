package P1;
public class Nodo<E> {
	private E dato;
	private Nodo<E> siguiente;
	Nodo(E dato, Nodo<E> siguiente){
		this.dato = dato;
		this.siguiente = siguiente;
	}
	Nodo(E dato){
		this(dato, null);
	}
	//Definimos métodos
	public E getDato() {
		return dato;
	}
	public void setDato(E dato) {
		this.dato = dato;
	}
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}
}
