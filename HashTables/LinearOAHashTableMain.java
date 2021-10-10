package p2;

public class LinearOAHashTableMain {
	public static void main(String[] args) throws ExistingElementException, FullDictionaryException, ElementNotFoundException {
		int max = 100;
		LinearOAHashTable<Integer,Integer> HashTable = new LinearOAHashTable<Integer,Integer>(max);
		for(int i = (max/2)-2; i >= 0; i--) {
			HashTable.insert(i,i);
			HashTable.insert(i+max,i);
			int a = HashTable.search(i);
			System.out.println("El valor es: " + a);
			System.out.println(HashTable.size());
		}
		for(int i = 0; i < 2;i++) {
			HashTable.insert(i+max*2,i);
		}
		for(int j = 0;j<(HashTable.size()/2)-1;j++) {
			if(HashTable.table[j] != null) {
				System.out.print(HashTable.search(j));
				System.out.print(HashTable.getValue(j));
			}
			System.out.println();
		}
		System.out.println(HashTable.toString());
	}
}