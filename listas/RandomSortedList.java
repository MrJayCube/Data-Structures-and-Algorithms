package P1;
import java.util.Scanner;
import java.util.Random ;
public class RandomSortedList<E> implements List<E>{
	

	private Nodo<E> primero = null;
	private int talla = 0;
	
	RandomSortedList(){
		this.primero = null;
		this.talla = 0;
	}
	
	public void add(E data){
		Nodo<E> tope = primero;
		Nodo<E> aux = new Nodo<E>(data);
		Nodo<E> auxi;
		int pos = 0;
		 if (talla != 0) {
			 pos = new Random().nextInt(talla);
		 }
		 
		 for(int i = 0; i < pos-1 && i < talla; i++) {
			 	tope = tope.getSiguiente();
			}
		 if(pos!=0) {
			 auxi = tope.getSiguiente();
			 tope.setSiguiente(aux);
			 aux.setSiguiente(auxi);
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
		for(int i = 0; i != pos && i < this.talla-1; i++) {
			tope = tope.getSiguiente();
		}
		if(tope == null) throw new WrongIndexException();
		Nodo<E> topeb = tope;
		return topeb.getDato();
	}

	public int size() {
		return talla;
	}
	
	public String toString(){
		Nodo<E> tope = primero;
		String dato = tope.getDato() + "";
		for(int i = 0;i < talla-1; i++) {
			dato = dato + "," + tope.getSiguiente().getDato();
			tope = tope.getSiguiente();
		}
		dato = "[" + dato + "]";
		return dato;
	}

	public int search(E data) {
		Nodo<E> tope = primero;
		int pos = 0;
		while(!tope.getDato().equals(data) && tope.getSiguiente()!=null) {
			tope = tope.getSiguiente();
			pos++;
		}
		if(tope.getDato().equals(data)) {
			return pos;
		}
		return -1;
	}
}