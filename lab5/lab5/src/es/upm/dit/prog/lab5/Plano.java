package es.upm.dit.prog.lab5;

import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Clase usada para representar el plano de una ciudad. Se indica la situacion y
 * la altura de sus edificios.
 * 
 * @version 110.405 09:30
 */
public class Plano {

	/**
	 * Datos de edificios existentes en la ciudad. El array almacena la altura
	 * de los edificios.
	 * 
	 * Ejemplo: datos[2][3] es la altura del edificio situado en y=2, x=3.
	 * 
	 * He decidido que el primer indice este asociado al eje Y y que el segundo
	 * indice este asociado al eje X.
	 * 
	 * A la hora de pintar y escribir el mapa, el centro de coordenadas sera la
	 * esquina superior izquierda, con el eje X avanzando hacia la derecha en
	 * horizoltal, y el eje Y avanzando hacia abajo en vertical.
	 */
	private int[][] alturas;

	/**
	 * Crea una ciudad de tama�o indicado y sin edificios.
	 * 
	 * @param maxX
	 *            Anchura del mapa de la ciudad, o maximo tama�o en el eje X.
	 * @param maxY
	 *            Profundidad del plano de la ciudad, o maximo tama�o en el eje
	 *            Y.
	 */
	public Plano(int maxX, int maxY) {
		alturas = new int[maxY][maxX];
	}

	/**
	 * Devuelve el array de alturas.
	 * 
	 * @return Devuelve el array de alturas.
	 */
	public int[][] getAlturas() {
		int[][] copia = new int[alturas.length][];
		for (int y = 0; y < alturas.length; y++) {
			copia[y] = new int[alturas[y].length];
			for (int x = 0; x < alturas[y].length; x++) {
				copia[y][x] = alturas[y][x];
			}
		}
		return copia;
	}

	/**
	 * Determina si la coordenada (x,y) dada esta dentro de la ciudad.
	 * 
	 * @param x
	 *            Coordenada X.
	 * @param y
	 *            Coordenada Y.
	 * 
	 * @return Devuelve true si (x,y) esta dentro de la ciudad.
	 */
	public boolean dentro(int x, int y) {

		for (int i = 0; i < alturas.length; i++){
			if (x<0||y<0){
				return false;
			}
			if (x<alturas[i].length && y<alturas.length){
				return true;
			}			
		}return false;
}

	/**
	 * Devuelve la altura del edificio situado en la posicion dada.
	 * 
	 * @param x
	 *            Coordenada X de la posicion del edificio.
	 * @param y
	 *            Coordenada Y de la posicion del edificio.
	 * 
	 * @return Devuelve la altura del edificio situado en la posicion dada. Si
	 *         la posicion (x,y) esta situada fuera del plano, devuelve cero.
	 */
	public int getAltura(int x, int y) {
	
		if(dentro(x,y)){
			return alturas[y][x];
		}

		return 0;
	}

	/**
	 * Cambia el tama�o y los edificios de una ciudad.
	 * 
	 * @param alturas
	 *            Array con el nuevo tama�o de la ciudad, y la altura de los
	 *            edificios existentes en ella.
	 * 
	 * @throws Exception
	 *             Se lanzara una excepcion:
	 *             <ul>
	 *             <li>si el valor pasado en este parametro es null.</li>
	 *             <li>si el array no es de tama�o 1x1 o mayor.</li>
	 *             <li>si el array no es rectangular, es decir, existen filas o
	 *             columnas de distinto tama�o.</li>
	 *             <li>si el array contiene algun numero negativo</li>
	 *             </ul>
	 */
	public void setAlturas(int[][] alturas) throws Exception {

		// PENDIENTE DE HACER
	}

	/**
	 * Destruye todos los edificios existentes en la ciudad y crea edificios
	 * nuevos.
	 * 
	 * @param semilla
	 *            Este valor indica que ciudad desea construirse. Para cada
	 *            valor de la semilla se construira una ciudad diferente.
	 */
	public void creaCiudad(long semilla) {

		Random r = new Random(semilla);
		for (int y = 0; y < alturas.length; y++) {
			for (int x = 0; x < alturas[y].length; x++) {
				if (r.nextInt(10) > 6) { // posibilidad de crear edificio = 70%
					alturas[y][x] = r.nextInt(25);
				} else { // posibilidad de no construir = 30%
					alturas[y][x] = 0;
				}
			}
		}
	}

	/**
	 * Destruye todos los edificios existentes en la ciudad y crea
	 * aleatoriamente edificios nuevos. Cada vez que se llame a este metodo se
	 * crea una ciudad totalmente diferente.
	 */
	public void creaCiudad() {
		creaCiudad(new Date().getTime());
	}

	/**
	 * Construye un edificio en la posicion (x,y) dada. La altura del edificio
	 * debe ser altura.
	 * 
	 * Si en la posicion dada ya hay un edificio, este se destruye, y luego se
	 * construye el nuevo edificio.
	 * 
	 * @param x
	 *            Coordenada X de la posicion donde construir el edificio.
	 * @param y
	 *            Coordenada Y de la posicion donde construir el edificio.
	 * @param altura
	 *            Altura del edificio a construir.
	 * 
	 * @throws Exception
	 *             Lanza una excepcion si la posicion (x,y) dada esta fuera de
	 *             los limites de la ciudad. Tambien lanza una excepcion si la
	 *             altura dada es negativa.
	 */
	public void construyeEdificio(int x, int y, int altura) throws Exception {

		// PENDIENTE DE HACER
	}

	/**
	 * Destruye el edificio situado en la posicion dada. Si en la posicion dada
	 * no hay edificio, no hay que hacer nada.
	 * 
	 * @param x
	 *            Coordenada X de la posicion del edificio.
	 * @param y
	 *            Coordenada Y de la posicion del edificio.
	 * 
	 * @throws Exception
	 *             Lanza una excepcion si la posicion (x,y) dada esta fuera de
	 *             los limites de la ciudad.
	 */
	public void destruyeEdificio(int x, int y) throws Exception {

		// PENDIENTE DE HACER
	}

	/**
	 * Calcula la altura media de los edificios de la ciudad.
	 * 
	 * @return La altura media de los edificios de la ciudad.
	 */
	public double alturaMedia() {

		// PENDIENTE DE HACER

		return 0;
	}

	/**
	 * Busca el edificio mas alto y devuelve su altura.
	 * 
	 * @return La altura del edificio mas alto de la ciudad. Si no hay
	 *         edificios, devuelve 0.
	 */
	public double alturaMaxima() {

		// PENDIENTE DE HACER

		return 0;
	}

	/**
	 * Busca el edificio mas bajo y devuelve su altura.
	 * 
	 * @return La altura del edificio mas bajo de la ciudad. Si no hay
	 *         edificios, devuelve 0.
	 */
	public double alturaMinima() {

		// PENDIENTE DE HACER

		return 0;
	}

	/**
	 * Cuenta el numero de edificios existentes en la ciudad.
	 * 
	 * @return El numero de edificios existentes en la ciudad.
	 */
	public int cuentaEdificios() {

		// PENDIENTE DE HACER

		return 0;
	}

	/**
	 * Cuenta el numero de edificios existentes en la ciudad que esten pegados a
	 * otro edificio.
	 * 
	 * @return El numero de edificios existentes en la ciudad que no esten
	 *         pegados a otro edificio.
	 */
	public int cuentaEdificiosAislados() {

		// PENDIENTE DE HACER

		return 0;
	}

	/**
	 * Recorta los edificio altos. A todos los edificios que superen la altura
	 * dada, se les cortaran los pisos superiores para que no superen la altura
	 * maxima indicada.
	 * 
	 * @param altura
	 *            Altura maxima que no pueden superar los edificios. Si la
	 *            altura dada es negativa, entonces se limitara la altura a
	 *            cero.
	 * 
	 * @return Devuelve el numero de edificios que han sido recortados para
	 *         ajustarse a la altuma maxima indicada.
	 */
	public int limitaAltura(int altura) {

		// PENDIENTE DE HACER

		return 0;
	}

	/**
	 * Consulta si en la posicion dada hay un edificio.
	 * 
	 * @param x
	 *            Coordenada X de la posicion a consultar.
	 * @param y
	 *            Coordenada Y de la posicion a consultar.
	 * 
	 * @return Devuelve false si la posicion (x,y) esta fuera del mapa, o si la
	 *         altura en esa posicion es 0. Devuelve true si la altura en esa
	 *         posicion es distinta de cero.
	 * 
	 */
	public boolean hayEdificio(int x, int y) {

		// PENDIENTE DE HACER

		return false;
	}

	/**
	 * Explora el mapa buscando si existe algun edificio con la altura dada.
	 * 
	 * @return Devuelve true si en el plano existe algun edificio con altura
	 *         igual a la dada. Si no existe ningun edificio de esa altura,
	 *         entonces devuelve false.
	 * 
	 */
	public boolean existeEdificio(int altura) {

		// PENDIENTE DE HACER

		return false;
	}

	/**
	 * Crea una carretera desde la posicion (x0,y0) hasta la posicion (x1,y1).
	 * Se destruiran todos los edificios situados entre estos dos puntos.
	 * 
	 * @param x0
	 *            Coordenada X de la posicion donde empieza la carretera.
	 * @param y0
	 *            Coordenada Y de la posicion donde empieza la carretera.
	 * @param x1
	 *            Coordenada X de la posicion donde termina la carretera.
	 * @param y1
	 *            Coordenada X de la posicion donde termina la carretera.
	 * 
	 * @throws Exception
	 *             Se lanza una excepcion si las coordenada dadas estan situadas
	 *             fuera de la ciudad.
	 */
	public void creaCarretera(int x0, int y0, int x1, int y1) throws Exception {

		// PENDIENTE DE HACER
	}

	/**
	 * Devuelve un String describiendo el plano.
	 * 
	 * @return Devuelve un String describiendo el plano.
	 */
	public String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append("[ ");
		for (int y = 0; y < alturas.length; y++)
			for (int x = 0; x < alturas[y].length; x++)
				sb.append(alturas[y][x] + " ");
		sb.append("]");

		return sb.toString();
	}

	/**
	 * Escribe por pantalla el plano de la ciudad, indicando la altura de los
	 * edificios.
	 * 
	 * Escribe el mapa situando en origen de coordenadas arriba y a la
	 * izquierda. El eje X es el horizontal, y el eje Y es el vertical.
	 */
	public void escribe() {

		// Escribe los ejes
		System.out.println("O--> x");
		System.out.println("|\nV\ny");

		// Borde superior
		for (int x = 0; x < alturas[0].length; x++)
			System.out.print("---");
		System.out.println("---");

		for (int y = 0; y < alturas.length; y++) {
			System.out.print("|");
			for (int x = 0; x < alturas[y].length; x++) {
				System.out.printf("%3d", alturas[y][x]);
			}
			System.out.println(" |");
		}

		// borde inferior
		for (int x = 0; x < alturas[0].length; x++)
			System.out.print("---");
		System.out.println("---");
	}

	/**
	 * @param args
	 *            Argumentos de la linea de comandos
	 */
	public static void main(String[] args) {

		try {
			Plano p = new Plano(15, 20);

			p.creaCiudad(1);

			new PlanoGrafico(p);
			
			p.escribe();

			p.construyeEdificio(2, 0, 60);
			p.construyeEdificio(12, 19, 50);

			p.creaCarretera(0, 0, 14, 19);

		} catch (Exception exc) {

			System.err.println("Se ha producido un error: " + exc.getMessage());
		}
	}
}

/**
 * Crea una ventana donde dibuja un mapa y sus edificios.
 */
class PlanoGrafico extends JFrame {

	static final long serialVersionUID = 1L;

	// Copia del array de alturas del Plano.
	private int[][] datos;

	// Referencia al plano pasado como parametro en el constructor.
	private Plano p;

	/**
	 * Construye un objeto PlanoGrfico para dibujar el plano pasado como
	 * parametro.
	 * 
	 * @param p
	 *            Referencia alplano a dibujar.
	 */
	public PlanoGrafico(Plano p) {

		this.p = p;

		datos = p.getAlturas();

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setPreferredSize(new Dimension(300, 300));

		((JButton) getContentPane().add("North", new JButton("repinta")))
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						repinta();
					}
				});

		getContentPane().add(new JPanel() {

			static final long serialVersionUID = 1L;

			private Point proyeccion2D(int x, int y, int z) {

				double f_prof = 2;
				double f_altu = 2;

				double escalax = (double) (getWidth() - 20)
						/ (datos[0].length / f_prof + datos.length);

				double escalay = (double) (getHeight() - 20 - 100 * f_altu)
						/ (datos.length / f_prof);

				int vx = 10 + (int) ((x - y / f_prof + datos.length / f_prof) * escalax);
				int vy = getHeight()
						- 10
						+ (int) ((y / f_prof - datos.length / f_prof) * escalay - z
								* f_altu);

				return new Point(vx, vy);
			}

			private void pintaTerreno(Graphics g) {

				// Esquinas del terreno
				Point p1 = proyeccion2D(0, 0, 0);
				Point p2 = proyeccion2D(0, datos.length, 0);
				Point p3 = proyeccion2D(datos[0].length, datos.length, 0);
				Point p4 = proyeccion2D(datos[0].length, 0, 0);

				Polygon pol = new Polygon();
				pol.addPoint(p1.x, p1.y);
				pol.addPoint(p2.x, p2.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p4.x, p4.y);

				g.setColor(Color.white);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);
			}

			private void pintaEdificios(Graphics g) {

				for (int y = 0; y < datos.length; y++) {
					for (int x = 0; x < datos[y].length; x++) {

						pintaEdificio(g, x, y, datos[y][x]);
					}
				}
			}

			private void pintaEdificio(Graphics g, int x, int y, int z) {

				if (z == 0)
					return;

				// Esquinas del edificio
				Point p1 = proyeccion2D(x, y + 1, 0);
				Point p2 = proyeccion2D(x, y + 1, z);
				Point p3 = proyeccion2D(x + 1, y + 1, z);
				Point p4 = proyeccion2D(x + 1, y + 1, 0);
				Point p5 = proyeccion2D(x, y, z);
				Point p6 = proyeccion2D(x + 1, y, z);
				Point p7 = proyeccion2D(x + 1, y, 0);

				// pared frontal
				Polygon pol = new Polygon();
				pol.addPoint(p1.x, p1.y);
				pol.addPoint(p2.x, p2.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p4.x, p4.y);

				g.setColor(Color.lightGray);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);

				// pared lateral
				pol = new Polygon();
				pol.addPoint(p2.x, p2.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p6.x, p6.y);
				pol.addPoint(p5.x, p5.y);

				g.setColor(Color.white);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);

				// Techo
				pol = new Polygon();
				pol.addPoint(p7.x, p7.y);
				pol.addPoint(p6.x, p6.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p4.x, p4.y);

				g.setColor(Color.gray);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);

				// altura
				g.drawString("" + z, p2.x + 5, p2.y - 5);
			}

			protected void paintComponent(Graphics g) {
				pintaTerreno(g);
				pintaEdificios(g);
			}
		});
		pack();
		setVisible(true);
	}

	/**
	 * Relee la nueva disposicion de edificios y actualiza el dibujo del mapa.
	 */
	public void repinta() {
		datos = p.getAlturas();
		repaint();
	}

}
