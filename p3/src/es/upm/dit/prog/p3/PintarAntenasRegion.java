package es.upm.dit.prog.p3;

import java.awt.Color;

/** Clase para pintar antenas y puntos en una ventana cuadrada de 20 x 20.
 *  El origen de coordenadas se encuentra en el centro de la ventanta
 */
public class PintarAntenasRegion {

        private int                vx = 1000;
        private int                vy = 1000;
        private int            escala = 10;
        private int distanciaEtiqueta = 10;
        private Ventana laVentana = new Ventana(vx, vy);

        /**
         * Crea la ventana en la que se van a situar las antenas y puntos.
         * Dibuja los ejes de coordenadas.
         *
         * Modificaci—n de PintarVentanas. En esta clase, el origen de
         * coordenadas se encuentra en el centro. En este caso, se encuentra
         * en la esquina superior izquierda y las "y" crecen hacia abajo
         */

        public PintarAntenasRegion() {
//            laVentana.linea(0, vy / 2, vx, vy / 2, Color.black);
//            laVentana.linea(vx / 2, 0, vx / 2, vy, Color.black);

            // Escribe de 10 en 10 la etiqueta en los ejes.
            for (int i = 0; i <= vx; i = i + escala * distanciaEtiqueta) {
                laVentana.linea(i, 0 + 5, i, 0,
                        Color.black);
                if ((i / escala) != 0) {
                    laVentana.texto(
                     String.valueOf(i / escala), i - 5, vy - 10);
                    }
                laVentana.linea(i, 0, i, vy, Color.black);
                }

            for (int i = 0; i <= vy; i = i + escala * distanciaEtiqueta) {
                laVentana.linea(5, i, 0, i,
                        Color.black);
                if ((i / escala) != 0) {
                    laVentana.texto(
                            String.valueOf(100 - (i / escala)),
                            8, i + 4);
                    }
                laVentana.linea(0, i, vx, i, Color.black);
                }

            laVentana.pinta();
            }


        /**
         * Dibuja una antena direccional.
         * @param laAntena antena que se debe pintar
         */
        public void pintarAntenaDireccional(AntenaDireccional laAntena) {
            int x = (getCoordenadaX(laAntena.getPosicion().getX()
                    - laAntena.getRadio()));
            int y = (int) (((getCoordenadaY(laAntena.getPosicion().getY()))
                    - laAntena.getRadio() * escala));
            int radio = (int) laAntena.getRadio() * escala;
            int anguloInicio = (int) Math.toDegrees(laAntena.getAngulo()
                    - laAntena.getApertura() / 2);
            int anguloArco = (int) Math.toDegrees(laAntena.getApertura());

        laVentana.arco(x, y, radio * 2, radio * 2, anguloInicio, anguloArco,
                Color.black, Color.red);
        }

       /**
        * Dibuja una antena direccional en la ventana.
        * @param laAntena antena que se debe pintar
        */
 /*       public void pintarAntenaOmnidireccional(
                AntenaOmnidireccional laAntena) {

            int x = getCoordenadaX(laAntena.getPosicion().getX()
                    - laAntena.getRadio());
            int y = getCoordenadaY(laAntena.getPosicion().getY()
                    + laAntena.getRadio());
            int radio = Math.round(Math.round(
                    laAntena.getRadio() * escala));
            int diametro = radio * 1;

            laVentana.elipse(x, y, diametro, diametro,
                    Color.black, Color.yellow);
            pintarPunto(laAntena.getPosicion());
            laVentana.pinta();
            }
*/
        /**
         * Dibuja una antena direccional en la ventana.
         * @param elPunto punto que se debe pintar
         */
        public void pintarPunto(Punto elPunto) {

            int x = getCoordenadaX(elPunto.getX());
            int y = getCoordenadaY(elPunto.getY());

            laVentana.linea((int) x + 3 , (int) y + 3,
                    (int) x - 3 , (int) y - 3, Color.black);
            laVentana.linea((int) x - 3 , (int) y + 3,
                    (int) x + 3 , (int) y - 3, Color.black);
            laVentana.pinta();
            }

        private int getCoordenadaX(double x) {
          // Ojo. Se redondea, con lo cual hay un cierto error de representaci—n
            return (int) (x * escala);
            }

        private int getCoordenadaY(double y) {
          // Ojo. Se redondea, con lo cu‡l hay un cierto error de representaci—n
            return (int) (vy - (y * escala));
            }

}
