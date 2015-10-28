package es.upm.dit.prog.p1;

public class CalcularDistancias {
	

public double calcularDistancia (double x1, double y1, double x2, double y2){
	
//Actividades a realizar:
	
//Crear los dos puntos

//Calcular la distancia entre ellos usando la clase Punto
		
//Devolver el valor de la distancia
	
	Punto p1 = new Punto (x1,y1);
	Punto p2 = new Punto (x2,y2);
	
	return p1.distancia(p2);
}

public double calcularDistancia (double x1, double y1) {
	//Actividades a realizar:
	//Crear el punto a partir de las coordenadas
	//Calcular la distancia usando la clase Punto
	//Devolver el valor de la distancia
	
	Punto p1 = new Punto (x1,y1);
	
	return p1.distancia();
	
	
	}
public void imprimirDistancia (double x1, double y1) {
	
		//Actividades a realizar:
		//Calcular la distancia al origen del punto definido por las coordenadas
		//Escribir en pantalla las coordenadas del punto y la distancia al origen
	
	Punto p1 = new Punto (x1,y1);
	String coordenadas = p1.toString();
	
	System.out.println("Puntos en el eje = " +coordenadas);
	
	
	
	
	
	
	
		}
}