
import java.awt.Color;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ventana v = new Ventana(1024,768);
		int i = 0;
		int j = 0;
		int k = 500;
		int l = 0;
		while(true){
			v.linea(i, j, k,l, Color.BLACK);
			i++;
			k++;
			v.pinta();
		}

	}

}
