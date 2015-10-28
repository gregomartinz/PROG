package es.upm.dit.prog.p1;

public class PruebaCalcularDistancias {
	
public static void main(String[] args) {
	
CalcularDistancias cd = new CalcularDistancias();

System.out.println("Distancia entre puntos = " +cd.calcularDistancia(1, 2));

System.out.println("Distancia al eje de coordenadas = " +cd.calcularDistancia(1, 2, 3, 4));

cd.imprimirDistancia(1,2);

}

}
