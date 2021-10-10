package P1;
import java.util.Scanner;
public class ReversedSortedListImpl<E extends Comparable<E>> implements ReversedSortedList<E>{


	private Nodo<E> primero = null;
	private int talla = 0;

	ReversedSortedListImpl(){
		this.primero = null;
		this.talla = 0;
	}

	public void add(E data){
		Nodo<E> tope = primero;
		Nodo<E> aux = new Nodo<E>(data);
		Nodo<E> auxi;
		if (talla != 0) {
			int centro = busqueda(data);
			for(int i = 0; i < centro && tope.getSiguiente()!=null; i++) {
				tope = tope.getSiguiente();
			}
			if(centro == 0) {
				try {
					if(get(centro).compareTo(data) < 0) {
						aux.setSiguiente(primero);
						primero = aux;
					}else {
						auxi = primero.getSiguiente();
						primero.setSiguiente(aux);
						aux.setSiguiente(auxi);
					}
				} catch (WrongIndexException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				auxi = tope.getSiguiente();
				tope.setSiguiente(aux);
				aux.setSiguiente(auxi);
			}
		}else {
			aux.setSiguiente(tope);
			primero = aux;
		}
		talla++;
	}
	
	public void delete(int pos) throws WrongIndexException{
		if (pos < 0 || pos >= talla) throw new WrongIndexException();
		Nodo<E> tope = primero;
		if(pos != 0) {
			for(int i = 0; i < pos && i < talla; i++) {
				if(i == pos-1) {
					tope.setSiguiente(tope.getSiguiente().getSiguiente());
				}else {
					tope = tope.getSiguiente();
				}
			}
		}else  {
			primero = tope.getSiguiente();
		}
		talla--;
	}

	public E get(int pos) throws WrongIndexException{
		if (pos < 0 || pos >= talla) throw new WrongIndexException();
		Nodo<E> tope = primero;
		for(int i = 0; i < pos && i < this.talla-1; i++) {
			tope = tope.getSiguiente();
		}
		if(tope == null) throw new WrongIndexException();
		return tope.getDato();
	}

	public int size() {
		return talla;
	}

	public String toString(){
		Nodo<E> tope = primero;
		String dato = "";
		for(int i = 0;i < talla; i++) {
			dato = dato + " " + tope.getDato();
			tope = tope.getSiguiente();
		}
		dato = "[" + dato + " ]";
		return dato;
	}

	public int search(E data) {
		Nodo<E> tope = primero;
		int centro = busqueda(data);
		try {
			if(get(centro).equals(data)) {
				return 1;
			}
		} catch (WrongIndexException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int busqueda(E data){
		int inf = 0;
		int sup = talla-1;
		int centro = 0;
		Nodo<E> tope = primero;
		while(inf<=sup) {
			centro = sup-inf/2;
			try {
				if(get(centro).compareTo(data) > 0) {
					inf = centro + 1;
					//centro = centro + 1;
				}else if(get(centro).compareTo(data) < 0){
					sup = centro - 1;
				}else {
					break;
				}
			} catch (WrongIndexException e) {
				e.printStackTrace();
			}
		}
		return centro;
	}
}