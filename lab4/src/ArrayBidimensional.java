import java.util.*;

/**
 * @author monica
 * @version Marzo 2011
 *
 */
public class ArrayBidimensional {
	// atributo el array bidimensional
	int [][] array;

	/**
	 * Constructor de la clase, crea e inicializa el array
	 * bidemensional con 10 elementos por dimensión
	 * @param	semilla		valor de semilla para la generación de numeros aleatorios
	 */
	public ArrayBidimensional(int semilla) {
		array = new int[10][10];
		Random aleatorio = new Random(semilla);
		for (int i=0; i<array.length; i++){
			for (int j=0; j<array[i].length; j++){
				array[i][j] = aleatorio.nextInt(50);
			}
		}
		
	}
	
	/**
	 * devuelve el número de veces que un determinado valor
	 * aparece en el array
	 * @param	valorBuscado	valor del numero buscado en el array
	 * @return	numero de veces que el valor buscado aparece en el array
	 */
	// declaracion y cuerpo del método numeroOcurrencias aquí

	public void numeroOcurrencias(int valorBuscado){
		int n=0;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				if(array[i][j]==valorBuscado){
					n++;}
			}
		}
		if(n==0){
			System.out.println("El jodido número no aparece en la matríz de los cojones joder!");
		}
		if(n>0){
			System.out.println("aparece "+n +" veces");

	}}
	/**
	 * suma todos los valores del array y haya la media
	 * @param no se usa
	 * @return media de los valores del array
	 */
	// declaración y cuerpo del método calculaMedia aquí
	public double calcularMedia(){
		
		return 0;
	}
	/**
	 * recorre el array en busca del menor valor
	 * @param no se usa
	 * @return valor menor encontrado en el array
	 */
	// declaración y cuerpo del método buscaMenor aquí
	public int buscaMenor(){
		
		return 0;
	}
	
	/**
	 * busca un valor pasado como parámetro en el array
	 * @param valorBuscado	valor buscado en el array
	 * @return true si el valor buscado se ha encontrado en el array; false si no
	 */
	public boolean buscaValor (int valorBuscado){
		for (int i=0; i<array.length; i++){
			for (int j=0; j<array[i].length; j++){
				if (array[i][j] == valorBuscado) return true;
			}
		}
		return false;
	}
	
	/**
	 * convierte el array en un String manteniendo la estructura
	 * de filas y columnas
	 */
	public String toString (){
		String contenidoArray = "";
		for (int i=0; i<array.length; i++){
			for (int j=0; j<array[i].length; j++)
				contenidoArray += array[i][j] + "\t";
			contenidoArray += "\n";
		}
		return contenidoArray;
	}
	
	/**
	 * busca el valor mayor de todo el array
	 * @return el mayor valor encontrado en el array
	 */
	public int buscaMayor (){
		int numeroMayor = array[0][0];
		for (int i=0; i< array.length; i++){
			for (int j=0; j< array[i].length; j++){
				if (array[i][j] > numeroMayor)
					numeroMayor = array[i][j];
			}
		}
		return numeroMayor;
	}
	

	/**
	 * devuelve un String con los índices del número mayor
	 * de array
	 */
	public String buscaIndicesMayor (){
		String posiciones = "";
		int numeroMayor = buscaMayor();
		
		//ya se cual es el numero mayor ahora busco los
		// indices de todas sus apariciones
		for (int i=0; i< array.length; i++){
			for (int j=0; j< array[i].length; j++){
				if (array[i][j] == numeroMayor){
					posiciones += "array["+i+"]["+j+"]  ";
				}
			}
		}
		return posiciones;
	}
	

}