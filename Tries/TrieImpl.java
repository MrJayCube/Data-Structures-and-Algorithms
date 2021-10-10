package p3;
import java.util.List;
import java.util.LinkedList ;
import p3.ElementNotFoundException;
public class TrieImpl <E> implements Trie <E> {
	TrieNode<E> root;
	int numE; //N�mero de elementos
	int numN; //N�mero de nodos
	
	public TrieImpl() {
		root = new TrieNode<E>();
		numE = 0; //No hay ning�n elemento al crear el arbol.
		numN = 1; //Hay un nodo inicial al crear el arbol.
	}
	
	public void insert(String key, E data) throws ExistingElementException {
		TrieNode<E> current = root; //Puntero donde definir el punto en el arbol que nos encontramos
		TrieNode<E> next;
		int i = 0;
		char c; //Caracter que buscar
		while(i<key.length()) {
			c = key.charAt(i);
			next = current.getChildNode(c); //Guarda el arco siguiente cuya clave sea el charAt de la clave
			if(next == null) { //Si no hay un nodo siguiente
				//Crear nodo
				next = new TrieNode<E>(); //Guardamos el siguiente nodo
				current.addChildNode(c, next); //A�adimos el siguiente nodo al actual
				current = next; //Avanzamos al siguiente nodo
				numN++; //Incrementamos contador de nodos
			}else { //Si hay un nodo siguiente
				//Recuperar nodo y avanzar
				current = next; //Avanzamos al siguiente nodo
			}
			i++; //Incrementamos contador
		}
		if(current.data == data) { 
			throw new ExistingElementException(); //Si el elemento que queremos insertar ya existe lanzamos excepci�n
		}else {
			current.data = data; //Si no, a�adimos el elemento al nodo.
		}
		numE++; //Incrementamos el n�mero de elementos.
	}

	public E search(String key) throws ElementNotFoundException {
		TrieNode<E> current = busquedaPorIndice(key); //B�scamos el nodo con el �ndice key y guardamos en current
		if(busquedaPorIndice(key)!=null && current.data!=null) {
			return current.data; //Si se ha encontrado alg�n nodo con el �ndice y su data no es nulo devolvemos el elemento.
		}
			throw new ElementNotFoundException(); //Si no, llamamos a la excepci�n
		}
	
	public TrieNode<E> busquedaPorIndice(String key) {
		TrieNode<E> current = root; //El nodo de inicio es root y lo guardamos en current
		TrieNode<E> next = null; 
		int i = 0; //iniciamos contador
		char c; //Caracter que buscar
		while(i<key.length()) { //Si no hemos llegado al final de la cadena
			c = key.charAt(i); //Guardamos el caracter i de la cadena
			next = current.getChildNode(c); //Guarda el arco siguiente cuya clave sea el charAt de la clave
			if(next == null) {
				break; //Si no hay siguiente, salimos del bucle.
			}else {
				current = next; //Si hay siguiente decimos que el nodo actual es el siguiente
			}
			i++; //Incrementamos contador
		}
		if(i==key.length()) {
			return current; //Si hemos recorrido toda la cadena, implica que la cadena existe, devolvemos el nodo.
		}
		else {
			return null;  //Si no, quiere decir que no existe y devolvemos un null
		}
	}

	public void delete(String key) throws ElementNotFoundException {
		TrieNode<E> current = root; //El nodo actual es el principal
		TrieNode<E> next; //Creamosm nodo siguiente
		TrieNode<E> contiene = current; //Creamos nodo contiene para identificar desde que nodo deberemos borrar
		int pos = 0; //Nos encontramos en la posici�n 0
		int i = 0; //Declaramos contador
		char c; //Caracter que buscar
		while(i<key.length()) { //Mientras no lleguemos al final de la cadena
			c = key.charAt(i); //Almacenamos el caracter en la posici�n del contador i
			next = current.getChildNode(c); //Guarda el arco siguiente cuya clave sea el charAt de la clave
			if(next == null) { //Si no hay siguiente
				if(current.data != null) { //Si no hay elemento
					throw new ElementNotFoundException(); //Llamamos a la excepci�n
				}
				break; //Salimos del bucle
			}else {
				if(current.data != null || current.numChildrenNodes()>1) { //Si hay alg�n elemento y tiene m�s de un hijo
					contiene = current; //Entonces se�alamos que este nodo no se puede eliminar
					pos = i; //Indicamos que la posici�n pos no se puede eliminar
				}
				current = next; //Avanzamos en el arbol
			}
			i++; //Incrementamos contador
		}
		if(i==key.length()) { //Si hemos llegado al final de la clave
			if(current.numChildrenNodes()>0) { //Si el nodo en el que nos encontramos tiene hijo
				current.data = null; //Simplemente borramos el elemento
				numE--; //Decrementamos numero de elementos
			}else {
				borrado(contiene,key,pos); //Si no, entonces borramos desde contiene
				numE--;
			}
		}else {
			throw new ElementNotFoundException(); //Si no llegamos al final de la clave, salta excepci�n
		}
	}
	
	private void borrado(TrieNode<E> current, String key,int j) {
		TrieNode<E> auxiliar = current; //Guardamos un auxiliar que ser� el nodo del que partimos
		int c; //Variable para ser llamada en recursividad a los m�todos
		for(int i = 0; i < current.numChildrenNodes() && j < key.length();i++) {
			if(key.charAt(j) == current.getArcs()[i]) { //Si el nodo actual contiene un hijo que coincida con el caracter de la posici�n j de key, entonces:
				auxiliar = current.getChildNode(current.getArcs()[i]); //auxiliar es el siguiente nodo que contenga el caracter de la posici�n j de key
				current.removeChildNode(current.getArcs()[i]); //Eliminamos del nodo actual la referencia el nodo que contenga la posici�n j de key
				numN--;
				c = j+1;
				borrado(auxiliar,key,c); //Se llama a si mismo para hacer lo mismo con los siguientes nodos
			}
		}
	}

	public List<E> list() {
		TrieNode<E> current = root; //El nodo actual es root
		List<E> lista = new LinkedList<E>(); //Creamos una lista enlazada
		List<E> tolist = busqueda(current,lista); //Creamos una lista que almacenar� la lista de elementos devuelta por el m�todo b�squeda
		return tolist; //Devolvemos la lista de elementos
	}
	
	private List<E> busqueda(TrieNode<E> current, List<E> lista){
		TrieNode<E> auxiliar; //El nodo actual es auxiliar
		if(numN > 0) { //Si hay m�s de un elemento
			for(int i = 0; i < current.numChildrenNodes();i++) {
				auxiliar = current.getChildNode(current.getArcs()[i]); //Para cada hijo del nodo en que nos encontramos guardamos en auxiliar
				if(auxiliar.data != null) { //Para cada hijo del nodo en que nos encontremos, comprobamos si contiene elemento
					lista.add(auxiliar.data); //Si contiene elemento, entonces lo a�adimos a la lista
				}
				busqueda(auxiliar,lista); //Llamamos de forma recursiva al m�todo
			}
		}
		return lista; //Devolvemos la lista de elementos
	}

	public List<E> prefixSearch(String prefix) {
		TrieNode<E> current = root; //El nodo en que nos encontramos es current
		List<E> lista = new LinkedList<E>(); //Creamos una lista enlazada llamada lista
		List<E> tolist; //Creamos una lista llamada tolist
		current = busquedaPorIndice(prefix); //Guardamosm en current el nodo devuelto por el m�todo busquedaporindice
		if(current!=null) { //So el m�todo ha devuelto un nodo
			tolist = busqueda(current, lista); //entonces hacemos que tolist sea la lista de elementos que hemos devuelto con el m�todo busqueda del nodo anterior
			return tolist; //devolvemos la lista de elementos
		}
		return lista; //devolvemos una lista vac�a
	}
	
	public String toString() {
		TrieNode<E> current = root; //Nuestro nodo inicial es la raiz
		String lista = ""; //Hacemos un string vac�o
		if(numN == 0) { //Si hay solo un nodo
			return "(0 -- @ --> {/}, \n" + current.toString(); //Entonces no hay �rbol que mostrar
		}else{
			 lista = representarArbol(current,0,'@'); //Si no, llamamos a representar �rbol y guardamos el string del arbol
			 return lista; //devolvemos el string del arbol
		}
	}
	
	private String representarArbol(TrieNode<E> current,int j,char caracter) {
		int p;
		char [] arcs = new char[current.numChildrenNodes()]; //Array que contiene los arcos
		String lista = ""; //Cadena vac�a
		for(int m = j; m > 0; m--) {
			lista += "  "; //Por cada nivel en que nos encontremos a�adimos dos espacios
		}
		if(current.data == null) { //Si el nodo actual no contiene elemento
			lista += "("+j+") -- "+ caracter +" --> {/} , ["; //Mostramos "/" Ej: (1) -- t --> {/} , [
		}else {
			lista += "("+j+") -- " + caracter + " --> {" + current.data + "} , ["; //Si no, mostramos el elemento Ej: (4) -- t --> {tHat} , [
		}
		for(int k = 0;k < arcs.length;k++) {
			arcs[k] = current.getArcs()[k]; //El caracter del array ser� el arco del nodo actual
			lista += arcs[k]; //A�adimos al string el caracter Ej: (1) -- t --> {/} , [h
			if(k!=arcs.length-1) { 
				lista += ", "; //So no hemos llegado al final, a�adimos una coma
			}
		}
		lista += "] \n"; //Adorno Ej: (1) -- t --> {/} , [h]
		for(int i = 0; i < arcs.length;i++) {
			p = j+1; //Por cada arco del nodo
			lista += representarArbol(current.getChildNode(arcs[i]),p,arcs[i]); //A�adimos al String lo que se nos devuelva de forma recursiva, llamandonos a nosotros mismos
		}
		return lista; //Devolvemos el String
	}

	public int size() {
		return numE; //Devolvemos el n�mero de elementos
	}

	public int numNodes() {
		return numN; //Devolvemos el n�mero de nodos
	}
}