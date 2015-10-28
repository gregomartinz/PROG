package es.upm.dit.prog.lab5;

import junit.framework.*;

/**
 * Clase de prueba para el m'etodo "dentro" de la clase Plano
 * 
 * @author PROG
 * @version abril 2011
 *
 */
public class PlanoTestDentro extends TestCase {

	/**
	 * Plano (ciudad) que se utilizar'a durante las pruebas
	 */
	private Plano p;

	/**
	 * M'etodo que crea un plano (ciudad) sobre el que realizar las pruebas
	 */
	public void setUp() {
		p = new Plano(40, 20);
	}

	/**
	 * M'etodo que prueba el funcionamiento del m'etodo en casos "normales", 
	 * es decir, coordenadas que est'an claramente en el interior o en el exterior de la ciudad.
	 */
	public void testCasoNormal() {
		assertTrue(p.dentro(20, 10));
		assertFalse(p.dentro(10, 30));
	}

	/**
	 * M'etodo que prueba coordenadas que coinciden con las esquinas del plano.
	 */
	public void testEsquinas() {
		assertTrue(p.dentro(0, 0));
		assertTrue(p.dentro(0, 19));
		assertTrue(p.dentro(39, 0));
		assertTrue(p.dentro(39, 19));
	}

	/**
	 * M'etodo que prueba coordenadas que est'an lindando con las esquinas por el exterior
	 * (es decir, que no est'an dentro de la ciudad).
	 */
	public void testEsquinasOut() {
		assertFalse(p.dentro(0, 20));
		assertFalse(p.dentro(40, 0));
		assertFalse(p.dentro(40, 20));
	}

	/**
	 * M'etodo que prueba coordenadas que se encuentran dentro de la ciudad,
	 * pero en los bordes.
	 */
	public void testBordesIn() {
		assertTrue(p.dentro(4, 0));
		assertTrue(p.dentro(0, 4));
		assertTrue(p.dentro(39, 8));
		assertTrue(p.dentro(9, 19));
	}

	/**
	 * M'etodo que prueba coordenadas que se encuentran fuera de la ciudad,
	 * justo al lado de los bordes.
	 */
	public void testBordesOut() {
		assertFalse(p.dentro(40, 8));
		assertFalse(p.dentro(9, 20));
	}

	/**
	 * M'etodo que prueba coordenadas negativas.
	 */
	public void testCoordenadasNegativas() {
		assertFalse(p.dentro(-1, -1));
		assertFalse(p.dentro(-1, 2));
		assertFalse(p.dentro(2, -1));
	}

	public static void main(String args[]) {
		junit.textui.TestRunner.run(PlanoTestDentro.class);
	}
}
