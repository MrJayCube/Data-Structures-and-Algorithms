package p3;

import java . util . List ;

public interface Trie <E> {
	public void insert ( String key , E data ) throws ExistingElementException;
	public E search ( String key ) throws ElementNotFoundException;
	public void delete ( String key ) throws ElementNotFoundException;
	public List <E > list ();
	public List <E > prefixSearch ( String prefix );
	public int size ();
	public int numNodes ();
}