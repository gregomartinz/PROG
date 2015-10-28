package es.upm.dit.prog.p1;
/**
* Clase que permite representar puntos en un sistema de coordenadas cartesianas.
* Cada punto se representa por su abcisa y ordenada
*/
public class Punto {
	
private double x;
private double y;

public Punto(double laX, double laY) {
	
x = laX;
y = laY;
}

public double getX() {
return x;
}

public void setX(double laX) {
x = laX;
}

public double getY() {
return y;
}

public void setY(double laY) {
y = laY;
}

public double distancia() {
return Math.sqrt ((x * x) + (y * y));
}

public double distancia(Punto q) {
return Math.sqrt (((x - q.x) * (x - q.x)) + ((y - q.y) * (y - q.y)));
}

public String toString() {
String coordenadas;
return coordenadas = "(" + x + "," + y + ")";
}
}