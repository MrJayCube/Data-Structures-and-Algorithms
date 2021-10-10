package p2;

public class LinearOAHashTable<K,V> implements PermanentDictionary<K,V> {
	class TableEntry<K,V>{
		K key; //Valor de la clave
		private V value; //Valor a almacenar

		private TableEntry(K key, V value){ //Definimos constructor
			this.key = key; //Asignamos la clave al objeto
			this.value = value; //Asignamos el valor al objeto
		}

		public boolean equals (Object obj) {
			if(obj instanceof LinearOAHashTable<?,?>.TableEntry<?,?>){ //Si el objeto es una instancia de la clase
				TableEntry<K,V> entry = (TableEntry<K,V>)obj; 
				return entry.key.equals(this.key); //Realizamos comparación y devolvemos booleano
			}
			return false; //No es una instancia, devolvemos false
		}
	}

	TableEntry<K,V>[] table;
	protected int m; //Tamaño máximo de la tabla
	protected int n; //Tamaño mínimo de la tabla

	LinearOAHashTable(int m) {
		this.m = m;
		this.table = new TableEntry[m];
		this.n = 0;
	}
	public void insert (K key, V value) throws ExistingElementException, FullDictionaryException{
		if(this.n == this.m) throw new FullDictionaryException();
		int pos = hash(key);
		int i = pos;
		boolean found = false;
		TableEntry<K,V> entry = null;
		int fin = this.m;
		while(i<fin && !found){
			entry = this.table[i];
			if(entry==null) {
				entry = new TableEntry<K,V>(key,value);
				found = true;
				this.n++;
				this.table[i] = entry;
			}else {
				if(entry.equals(new TableEntry<K,V>(key,null)))throw new ExistingElementException();
				else {
					System.out.println("Key Collition " + i + ": {" + key + "." + entry.key + "}");
					if(i+1 == fin) {
						fin = pos;
						i = 0;
					}else {
						i++;
					}
				}
			}
		}
	}

	public V search(K key) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		TableEntry<K,V> entry = new TableEntry<K,V>(key, null);
		int i = hash(key);
		final int i2 = i;
		boolean b = true;
		while(this.table[i] != null && b) {
			if(b = !this.table[i].equals(entry)){
				//System.out.println(i);
				if(i+1 == this.m) {
					i = 0;
				}else {
					i++;
				}
				if( i2 == i)
					throw new ElementNotFoundException();
			}

		}
		if(this.table[i] != null){ 
			return this.table[i].value;
		}else {
			throw new ElementNotFoundException();
		}
	}

	public int size() {
		return this.n;
	}

	public String toString() {
		int i = 0;
		String linea = "";
		TableEntry<K,V> entry = null;
		while(i < this.m) {
			entry = this.table[i];
			if(entry != null) {
				linea = linea + i + ": " + this.table[i].key + " => " + this.table[i].value + "\n";
			}else {
				linea = linea + i + ": null\n";
			}
			i++;
		}
		return linea;
	}

	int hash(K key) {
		return Math.abs(key.hashCode())%this.m;
	}

	protected V getValue(K key) {
		try {
			V valor = search(key);
			return valor;
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}

