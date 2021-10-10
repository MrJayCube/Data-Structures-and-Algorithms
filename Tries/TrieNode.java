package p3;
import java.util.HashMap;

public class TrieNode<E>{
	HashMap<Character, TrieNode<E>> children;
	E data ;
	public TrieNode(){
		children = new HashMap<Character, TrieNode<E>>();
	}
	
	public TrieNode(E data){
		children = new HashMap<Character, TrieNode<E>>();
		this.data = data;
	}
	
	public Character[] getArcs(){
		Character[] arcs = new Character[children.size()];
		int i = 0;
		for(Character c: children.keySet()) {
			arcs[i] = c;
			i++;
		}
		return arcs;
	}
	
	public TrieNode<E> getChildNode(Character arc){
		return children.get(arc); //Devolvemos el nodo hijo del arco indicado
	}
	
	public void addChildNode(Character arc , TrieNode<E> node){
		children.put(arc, node); //Añadimos un nodo hijo y el arco
	}
	
	public void removeChildNode(Character arc){
		children.remove(arc); //Borramos el nodo hijo del arco indicado
	}
	
	public int numChildrenNodes(){
		return children.size(); //Devolvemos el número de hijos
	}
}
