import java.awt.Color;
import java.util.Scanner;

public class Diana {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Esta parte nos crea la ventana
	Scanner s1 = new Scanner(System.in);
	Scanner s2 = new Scanner(System.in);
		System.out.println("Introducir anchura:");
			int a= s1.nextInt();
		System.out.println("Introducir la altura:");
			int b= s2.nextInt();
	
		Ventana ventana1  = new Ventana(a,b);
		
		// Aqui creamos el eje de coordenadas
		ventana1.linea(a/2,0,a/2,b,Color.black);
		ventana1.linea(0,b/2,a,b/2,Color.black);
		
		// Aqui ponemos el texto a cada eje
		ventana1.texto("Y", a/2, 15);
		ventana1.texto("X", 5, b/2);
		
		//Creo cada circunferencia a continuación
			int r1 = Math.min(5*a/6, 5*b/6);
		ventana1.elipse(a/2-r1/2, b/2-r1/2, r1, r1, Color.blue, Color.blue);
			int r2 = Math.min(4*a/6, 4*b/6);
		ventana1.elipse(a/2-r2/2, b/2-r2/2, r2, r2, Color.black, Color.black);
			int r3 = Math.min(3*a/6, 3*b/6);
		ventana1.elipse(a/2-r3/2, b/2-r3/2, r3, r3, Color.red, Color.red);
			int r4 = Math.min(2*a/6, 2*b/6);
		ventana1.elipse(a/2-r4/2, b/2-r4/2, r4, r4, Color.yellow, Color.yellow);
			int r5 = Math.min(a/6, b/6);
		ventana1.elipse(a/2-r5/2, b/2-r5/2, r5, r5, Color.white, Color.white);
				
		// Ejecuta todo lo que lleve ventana1
		ventana1.pinta();
	}

}
