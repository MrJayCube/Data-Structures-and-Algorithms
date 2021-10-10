package p2;

public class ExpandableLinearOAHashTableMain {
	public static void main(String[] args) throws ExistingElementException, FullDictionaryException, ElementNotFoundException {
		int max = 10;
		double maxLoad = (double) 3/4;
		ExpandableLinearOAHashTable<Integer,Integer> HashTable = new ExpandableLinearOAHashTable<Integer,Integer>(maxLoad);
		for(int i = (max/2)-1; i >= 0; i--) {
			HashTable.insert(i,i);
			HashTable.insert(i+max,i);
			int a = HashTable.search(i);
			System.out.println("El valor es: " + a);
			System.out.println(HashTable.size());
		}
		for(int i = 0; i < 2;i++) {
			//HashTable.insert(i+max*2,i);
		}
		for(int j = 0;j<HashTable.size();j++) {
			if(HashTable.table[j] != null) {
				System.out.print(HashTable.search(j) +" ");
				System.out.print(HashTable.getValue(j));
			}
			System.out.println();
		}
		System.out.println(HashTable.toString());
	}
}
