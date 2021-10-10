package p2;
public class ExpandableLinearOAHashTable<K,V> extends LinearOAHashTable<K,V> implements PermanentDictionary<K,V> {
	private static final int MIN_BUCKETS = 4;
	private double maxLoad;
	
	ExpandableLinearOAHashTable(double maxLoad) {
		super(MIN_BUCKETS);
		this.maxLoad = maxLoad;
	}

	public void insert (K key, V value) throws ExistingElementException, FullDictionaryException{
				super.insert(key,value);
				double previousLoad = (double) this.n/this.m;
				if(previousLoad >= maxLoad) {
					int previousM=this.m;
					recolocar();
					System.out.println("Expanding Hash Table: (m: "+previousM+", alpha: "+previousLoad+") -> (m: "+(double) this.n/this.m +", alpha: "+this.m+")");
				}
	}

	private void recolocar() {
		TableEntry[] auxiliar = new TableEntry[this.m*2] ;
		int fin = this.m;
		this.m = this.m*2;
		for(int j = 0;j<fin;j++) {
			boolean found = false;
				if(this.table[j]!=null) {
					int i = hash(this.table[j].key);
					while(!found) {
					if(auxiliar[i]==null){
						auxiliar[i] = this.table[j];
						found = true;
					}else {
						if(i+1 == this.m) {
							i = 0;
						}else {
							i++;
						}
					}
				}
			}
		}
		this.table = auxiliar;
	}
}

