package P5;

public class CoinChange {
	public static int [] coinChange (int [] v , int valor ) {
		int[][] matrix = new int[v.length][valor+1];
		int[] solution = new int[v.length+1];

		for(int i = 0; i < v.length;i++) {
			matrix[i][0] = 0;
			solution[i] = 0;
		}

		for(int i = 0;i < v.length;i++) {
			for(int j = 1; j <= valor; j++) {
				if(i == 0) { //Si nos encontramos en la primera fila
					if(v[0]>j) {
						matrix[i][j] = 999999999; //El valor de la moneda es mayor a lo que queremos cambiar, infinito.
					}else {
						matrix[i][j] = 1 + matrix[0][j-v[0]]; //Una moneda más
					}
				}else {
					if(v[i]>j) {
						matrix[i][j] = matrix[i-1][j]; //El valor de la moneda es mayor de lo que queremos cambiar, tomamos el valor de la moneda anterior
					}else { 
						matrix[i][j] = Math.min(matrix[i-1][j],1 + matrix[i][j-v[i]]); //Tomamos el mínimo entre la moneda anterior y la columna
					}
				}
			}
		}
		return SelectCoin(v,valor,matrix,solution); //Recogemos el vector con la solución
	}

	public static int[] SelectCoin(int [] v, int total, int [][] matrix, int[] solution){
		int pos = v.length;
		int valor = total;

		while(valor > 0){
			if(pos > 1 && matrix[pos-1][valor] == matrix[pos-2][valor]){ //Si tenemos el mismo número de monedas, entonces vamos a la fila anterior
				pos--;
			}else{
				solution[pos]++; //Incrementamos en uno el número de monedas de este tipo
				valor = valor - v[pos-1]; //Restamos el valor obtenido al que calcular
				solution[0]++; //Incrementamos el número de monedas que hemos usado
			}
		}
		if(valor < 0) {
			solution[0] = matrix[v.length-1][total]; //Introducimos el número de monedas infinito, no hay solución
		}
		return solution;
	}
}