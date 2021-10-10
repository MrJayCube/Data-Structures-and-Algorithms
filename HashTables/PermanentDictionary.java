package p2;

public interface PermanentDictionary <K ,V > {
void insert ( K key , V value ) throws ExistingElementException ,
FullDictionaryException ;
V search ( K key ) throws ElementNotFoundException ;
int size () ;
String toString() ;
}
