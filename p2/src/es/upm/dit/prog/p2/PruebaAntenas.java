package es.upm.dit.prog.p2;

public class PruebaAntenas {

	public static void main(String[] args) {

		Punto p   = new Punto(1, 2);
		Punto q   = new Punto(7,4);
		Punto pos = new Punto (0,0);
		
		
		AntenaOmnidireccional  ao = new AntenaOmnidireccional (3,pos);
		AntenaDireccional      ad = new AntenaDireccional ((Math.PI/4),(Math.PI/4),10,pos);
		Punto[] arrayPuntos = {new Punto (1, 2), new Punto(-3, -4.5), new Punto (-1, 4.2)};
		boolean[] arrayBoolean = new boolean[] {false, false, false};
		
		
		System.out.println("Dimensiones del array: " + arrayPuntos.length);		
		System.out.println("Antena omnidireccional = " +ao.enCobertura(p));
		System.out.println("Antena direccional = " +ad.enCobertura(q));

		arrayBoolean = ao.calcularCoberturaDeArray(arrayPuntos);		
		System.out.println(arrayBoolean[0] +" " + arrayBoolean[1] + " " + arrayBoolean[2]);

	}
}

