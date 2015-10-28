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
	 * bidemensional con 10 elementos por dimensi�n
	 * @param	semilla		valor de semilla para la generaci�n de numeros aleatorios
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
	 * devuelve el n�mero de veces que un determinado valor
	 * aparece en el array
	 * @param	valorBuscado	valor del numero buscado en el array
	 * @return	numero de veces que el valor buscado aparece en el array
	 */
	// declaracion y cuerpo del m�todo numeroOcurrencias aqu�

	public void numeroOcurrencias(int valorBuscado){
		int n=0;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				if(array[i][j]==valorBuscado){
					n++;}
			}
		}
		if(n==0){
			System.out.println("El jodido n�mero no aparece en la matr�z de los cojones joder!");
		}
		if(n>0){
			System.out.println("aparece "+n +" veces");

	}}
	/**
	 * suma todos los valores del array y haya la media
	 * @param no se usa
	 * @return media de los valores del array
	 */
	// declaraci�n y cuerpo del m�todo calculaMedia aqu�
	public double calcularMedia(){
		
		return 0;
	}
	/**
	 * recorre el array en busca del menor valor
	 * @param no se usa
	 * @return valor menor encontrado en el array
	 */
	// declaraci�n y cuerpo del m�todo buscaMenor aqu�
	public int buscaMenor(){
		
		return 0;
	}
	
	/**
	 * busca un valor pasado como par�metro en el array
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
	 * devuelve un String con los �ndices del n�mero mayor
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