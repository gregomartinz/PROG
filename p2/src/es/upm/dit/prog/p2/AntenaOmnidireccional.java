package es.upm.dit.prog.p2;

public class AntenaOmnidireccional {
	
	private double radio;
	private Punto posicion;

       public AntenaOmnidireccional(double radio, Punto posicion) {
		this.radio    = radio;
		this.posicion = posicion;
	}
	public boolean enCobertura (Punto p){
		//Actividades a realizar:
		//Determinar si el punto proporcionado como parametro
		//esta en cobertura.			
		double d = p.distancia(posicion);
		boolean s1 = (d<=radio);
		return s1;
	}
	public boolean[] calcularCoberturaDeArray (Punto[] arrayPuntos) {
		//Actividades a realizar:
		//Determinar si los puntos que se pasan en el array del argumento 
		// estan en cobertura. Se debe devolver un array booleano que indique 
		// si los puntos correspondientes estan en cobertura.
		// Ambos arrays deben tienen tres posiciones
		double d1 = arrayPuntos[0].distancia(posicion);
		double d2 = arrayPuntos[1].distancia(posicion);
		double d3 = arrayPuntos[2].distancia(posicion);
		
		boolean b1 = d1<=radio;
		boolean b2 = d2<=radio;
		boolean b3 = d3<=radio;
			
		
		return new boolean[]{b1, b2, b3};
	}
	
}
