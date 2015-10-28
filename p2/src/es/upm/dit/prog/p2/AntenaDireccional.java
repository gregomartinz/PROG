package es.upm.dit.prog.p2;

public class AntenaDireccional {

	private double angulo;			
	private double apertura;
	private double radio;			
	private Punto posicion;

       public AntenaDireccional(double angulo, double apertura, double radio,  Punto posicion) {

    	   this.radio    = radio;
    	   this.angulo   = angulo;
    	   this.posicion = posicion;
    	   this.apertura = apertura;
	}
	public boolean enCobertura (Punto p){
		//Actividades a realizar:
		//Determinar si el punto proporcionado como parametro
		//esta en cobertura.
		
		double d1 = p.distancia();
		double d2 = posicion.distancia();
		double a1 = p.getAngulo();
		double a2 = angulo - apertura/2;
		double a3 = angulo + apertura/2;

		
		boolean b1 = d1 <= radio;
		boolean b2 = a1 >= a2;
		boolean b3 = a1 <= a3;
		boolean b4 = d1 >= d2;
		boolean b5 = d1 <= d2 + radio;
		boolean b = b1 && b2 && b3 && b4 && b5;
		
			
		return b;
	}
}