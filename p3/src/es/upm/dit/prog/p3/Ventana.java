package es.upm.dit.prog.p3;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;


/**
 * Clase para pintar en una ventana en la pantalla.
 * Una ventana es una matriz rectangular de pixels.
 * Un pixel es un puntito de color en la pantalla.
 * Las pantallas típicas tienen 800x600 pixels (horizontal x vertical).
 * <p/>
 * En esta clase, el origen, pixel(0, 0),
 * se encuentra en la esquina superior izquierda de la ventana.
 * El eje X crece hacia la derecha.
 * El eje Y crece hacia abajo.
 * De esta forma, el pixel(ANCHO, ALTO) es el extremo inferior derecho.
 *
 * @author José A. Mañas &lt;jmanas@dit.upm.es&gt;
 * @version 4 (3.10.2006)
 */
public class Ventana extends JPanel {
    private static final Color FONDO = Color.WHITE;
    private final JFrame frame;
    private final java.util.List<Elemento> elementos;

    /**
     * Constructor: prepara una ventana para pintar encima.
     *
     * @param ancho número de pixels en horizontal.
     * @param alto  número de pixels en vertical.
     */
    public Ventana(int ancho, int alto) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();

        container.add(this);
        setPreferredSize(new Dimension(ancho, alto));
        frame.pack();
        elementos = new ArrayList<Elemento>();
    }

    /**
     * Añade algo que pintar.
     *
     * @param elemento a incorporar al dibujo.
     */
    private void add(Elemento elemento) {
        synchronized (elementos) {
            elementos.add(elemento);
        }
    }

    /**
     * Elimina todo lo que hay pintado: ventana en blanco.
     */
    public void borra() {
        synchronized (elementos) {
            elementos.clear();
        }
    }

    /**
     * Dibuja un rectángulo.
     *
     * @param nwx    coordenada X del extremo superior izquierdo.
     * @param nwy    coordenada Y del extremo superior izquierdo.
     * @param base   tamaño horizontal del rectángulo.
     * @param altura tamaño vertical del rectángulo.
     * @param borde  color del marco.
     * @param fondo  color del fondo.
     */
    public void rectangulo(int nwx, int nwy, int base, int altura, Color borde, Color fondo) {
        add(new Rectangulo(nwx, nwy, base, altura, borde, fondo));
    }

    /**
     * Dibuja una elipse.
     *
     * @param nwx    coordenada X del extremo superior izquierdo del rectángulo circunscrito a la elipse.
     * @param nwy    coordenada Y del extremo superior izquierdo del rectángulo circunscrito a la elipse.
     * @param base   eje horizontal.
     * @param altura eje vertical.
     * @param borde  color del marco.
     * @param fondo  color del fondo.
     */
    public void elipse(int nwx, int nwy, int base, int altura, Color borde, Color fondo) {
        add(new Elipse(nwx, nwy, base, altura, borde, fondo));
    }

    /**
     * Dibuja una elipse.
     *
     * @param nwx    coordenada X del extremo superior izquierdo del rectángulo circunscrito a la elipse.
     * @param nwy    coordenada Y del extremo superior izquierdo del rectángulo circunscrito a la elipse.
     * @param base   eje horizontal.
     * @param altura eje vertical.
     * @param borde  color del marco.
     * @param fondo  color del fondo.
     */
    /**
    x - The X coordinate of the upper-left corner of the arc's framing rectangle.
    y - The Y coordinate of the upper-left corner of the arc's framing rectangle.
    w - The overall width of the full ellipse of which this arc is a partial section.
    h - The overall height of the full ellipse of which this arc is a partial section.
    start - The starting angle of the arc in degrees.
    extent - The angular extent of the arc in degrees.
    type - The closure type for the arc: Arc2D.OPEN, Arc2D.CHORD, or Arc2D.PIE.
    **/
    
    public void arco(int nwx, int nwy, int base, int altura, int anguloInicio, int anguloArco, Color borde, Color fondo) {
        add(new Arco(nwx, nwy, base, altura, anguloInicio, anguloArco, borde, fondo));
    }
    
    /**
     * Traza una línea.
     *
     * @param x1    coordenada X del origen.
     * @param y1    coordenada Y del origen.
     * @param x2    coordenada X del destino.
     * @param y2    coordenada Y del destino.
     * @param color color de la línea.
     */
    public void linea(int x1, int y1, int x2, int y2, Color color) {
        add(new Linea(x1, y1, x2, y2, color));
    }

    /**
     * Escribe un texto en la ventana.
     *
     * @param texto texto a escribir.
     * @param x     coordenada X del extremo inferior izquierdo del rectángulo circunscrito al texto.
     * @param y     coordenada Y del extremo inferior izquierdo del rectángulo circunscrito al texto.
     */
    public void texto(String texto, int x, int y) {
        add(new Texto(texto, x, y));
    }

    /**
     * Imprime una imagen en la ventana.
     *
     * @param image imagen a imprimir.
     * @param x     coordenada X del extremo superior izquierdo del rectángulo circunscrito a la imagen.
     * @param y     coordenada Y del extremo superior izquierdo del rectángulo circunscrito a la imagen.
     * @param s     escala a la que se imprime.
     */
    public void imagen(Image image, int x, int y, double s) {
        add(new Imagen(image, x, y, s));
    }

    /**
     * Provoca que los elementos de la ventana se plasmen en la pantalla. Si no se pinta, la ventana se limita a ir
     * apuntando cosas a pintar.
     */
    public void pinta() {
        frame.repaint();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        synchronized (elementos) {
            Graphics2D g2 = (Graphics2D) g;

            g.setColor(FONDO);
            g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
            for (Elemento elemento : elementos) {
                elemento.pinta(g2);
            }
        }
    }

    /**
     * Cosas que podemos pintar en la ventana.
     */
    private interface Elemento {
        public void pinta(Graphics2D g);
    }


    private class Rectangulo implements Elemento {
        private final Shape shape;
        private final Color borde;
        private final Color fondo;

        Rectangulo(int nwx, int nwy, int base, int altura, Color borde, Color fondo) {
            this.shape = new Rectangle2D.Double(nwx, nwy, base, altura);
            this.borde = borde;
            this.fondo = fondo;
        }

        public void pinta(Graphics2D g) {
            if (fondo != null) {
                g.setColor(fondo);
                g.fill(shape);
            }
            if (borde != null) {
                g.setColor(borde);
                g.draw(shape);
            }
        }
    }

    private class Arco implements Elemento{
        private final Shape shape;
        private final Color borde;
        private final Color fondo;

        Arco(int nwx, int nwy, int base, int altura, int anguloInicial, int anguloArco, Color borde, Color fondo){
        	this.shape = new Arc2D.Double(nwx, nwy, base, altura, anguloInicial, anguloArco, 2);
        	this.borde = borde;
        	this.fondo = fondo;
        }
        
        public void pinta(Graphics2D g)
        {
            if (fondo != null) {
                g.setColor(fondo);
                g.fill(shape);
            }
            if (borde != null) {
                g.setColor(borde);
                g.draw(shape);
            }
        }
    }
    
    private class Elipse implements Elemento {
        private final Shape shape;
        private final Color borde;
        private final Color fondo;

        Elipse(int nwx, int nwy, int base, int altura, Color borde, Color fondo) {
            this.shape = new Ellipse2D.Double(nwx, nwy, base, altura);
            this.borde = borde;
            this.fondo = fondo;
        }

        public void pinta(Graphics2D g) {
            if (fondo != null) {
                g.setColor(fondo);
                g.fill(shape);
            }
            if (borde != null) {
                g.setColor(borde);
                g.draw(shape);
            }
        }
    }


    private class Linea implements Elemento {
        private final Shape shape;
        private final Color color;

        Linea(int x1, int y1, int x2, int y2, Color color) {
            this.shape = new Line2D.Double(x1, y1, x2, y2);
            this.color = color;
        }

        public void pinta(Graphics2D g) {
            if (color != null) {
                g.setColor(color);
                g.draw(shape);
            }
        }
    }

    private class Texto implements Elemento {
        private final String texto;
        private final int x;
        private final int y;

        Texto(String texto, int x, int y) {
            this.texto = texto;
            this.x = x;
            this.y = y;
        }

        public void pinta(Graphics2D g) {
            g.setColor(Color.BLACK);
            g.drawString(texto, x, y);
        }
    }

    private class Imagen implements Elemento {
        private final Image image;
	private AffineTransform at;

        Imagen(Image image, int x, int y, double s) {
            this.image = image;
	    at= new AffineTransform(s, 0, 0, s, x, y);
	    // at= AffineTransform.getTranslateInstance(x, y);
        }

        public void pinta(Graphics2D g) {
            g.drawImage(image, at, null);
        }
    }
}

