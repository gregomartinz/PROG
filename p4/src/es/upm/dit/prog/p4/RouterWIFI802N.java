package es.upm.dit.prog.p4;


public class RouterWIFI802N implements Radiante, RouterWIFI{


/**
* Esta clase modela una routr WIFI de comunicaciones de un tipo dado
* @author Alejandro Alonso
*/

        private double radio;
        private Coordenada posicion;

        /**
         * @param radio Distancia m‡xima de cobertura del router
         * @param posicion Coordenadas del punto donde se encuentra situado
         * el router
         */
        public RouterWIFI802N(double radio, Coordenada posicion) {
                this.radio    = radio;
                this.posicion = posicion;
        }

        /**
         * Consulta del valor del radio del router.
         * @return Valor actual del radio en radianes.
         */
        public double getRadio() {
                return radio;
        }
        
        /**
         * Asigna un nuevo valor al radio del router.
         * @param radio Nuevo valor del radio del router 
         */
        public void setRadio(double radio) {
                this.radio = radio;
        }
        /**
         * Consulta del punto (coordenadas) donde se encuentra el router.
         * @return El valor actual de las coordenadas de la posici—n del router.
         */
        public Coordenada getPosicion() {
                return posicion;
        }
        
        /** Asigna un nuevo valor del punto donde se encuentra el router.
         * @param p Nuevo valor de la posici—n del router
         */
        public void setPosicion(Coordenada p) {
                this.posicion = p;
        }
        
        /**
           * Calcula si el punto est‡ bajo la cobertura del router.
           * 
           * @return si est‡ en el ‡rea de cobertura
           * @param p Punto del que se quiere determinar su cobertura
        */

        public boolean enCobertura(Coordenada p) {
                return getPosicion().distancia(p) <= getRadio();
        }

        /**
         * Este m'etodo determina la velocidad de transmisi—n disponible en una
         * posici'on dada.
         * @param p Coordenada de la posici'on 
         * @return Devuelve el valor de la velocidad en Mbits/s
         * @throws Excepction Si el par'ametro es nulo
         */
        public int velocidadTransmisionWIFI (Coordenada p)
               throws Exception {

            if (p == null) {
                throw new Exception("Coordenada nula");
            }

            if (!enCobertura(p)) { return 0; }

            double distancia = getPosicion().distancia(p);
            
            if (distancia / radio < 0.5 )  {return 55;}
            if (distancia / radio < 0.75 ) {return 33;}
            return 11;

        }
}
