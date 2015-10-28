package es.upm.dit.prog.p5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Clase que permite representar puntos en un sistema de coordenadas
 * cartesianas.
 * Cada punto se representa por su abcisa y ordenada
 * @author Juan C. Dueñas
 */

public class Punto implements Coordenada {
        private double x;
        private double y;

        /**
         * Constructor del objeto.
         * @param x Valor de la coordenada de abcisas
         * @param y Valor de la coordenada de ordenadas
         */
        public Punto(double x, double y) {
                super();
                this.x = x;
                this.y = y;
        }

        /**
         * Este método compara las coordenadas del objeto con el parámetro del
         * método.
         * @param o Objeto con el que se quiere determinar la igualdad
         * @return Un valor booleano que indica si los elementos son o no
         * iguales
         */
        public boolean equals(Object o) {
            if (o == null) { return false; }
            if (o == this) { return true;  }
            if (!(o instanceof Punto)) { return false; }

            Punto p = (Punto) o;
                return (this.x == p.x) && (this.y == p.y);
        }

        /**
         * Permite acceder al valor de la abcisa.
         * @return Retorna el valor de la abcisa.
         */
        public double getX() {
                return x;
        }
        /**
         * Permite cambiar el valor de la abcisa.
         * @param x Valor nuevo de la abcisa
         */
        public void setX(double x) {
                this.x = x;
        }

        /**
         * Permite acceder al valor de la ordenada.
         * @return Retorna el valor de la ordenada.
         */
        public double getY() {
                return y;
        }
        /**
         * Permite cambiar el valor de la ordenada.
         * @param y Valor nuevo de la ordenada
         */
        public void setY(double y) {
                this.y = y;
        }

        /**
         * Este m'etodo calcula la distancia entre las coordenadas del objeto y
         * el origen de coordenadas.
         * @return Distancia entre el punto que representa el objeto y el origen
         */

        public double distancia() {
                return Math.sqrt((x * x) + (y * y));
        }

        /**
         * Este m'etodo calcula la distancia entre las coordenadas del objeto y
         * el punto que se pasa como par'ametro.
         * @param q Punto respecto al que se quiere calcular la distancia
         * @return Distancia entre los dos puntos
         */
        public double distancia(Coordenada q) {
                return Math.sqrt(((x - q.getX()) * (x - q.getX()))
                        + ((y - q.getY()) * (y - q.getY())));
        }

        /**
         * Genera una tira de caracteres con las coordenadas del punto entre
         * paréntesis.
         * @return Tira de caracteres que representa el punto
         */
        public String toString() {

            DecimalFormat df = new DecimalFormat("#####0.0000000");
            DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();

            dfs.setDecimalSeparator(',');
            df.setDecimalFormatSymbols(dfs);

            return " " + df.format(x) + " " + df.format(y);
        }

        /**
         * Calcula el 'angulo en radianes que forma la recta que une el punto
         * con el centro y el eje de abcisas.
         * @return angulo respecto al eje x
         */
        public double getAngulo() {
                double a = Math.atan2(y, x);
                if (a < 0) { a = (2 * Math.PI) + a; }
                return a;
        }

}