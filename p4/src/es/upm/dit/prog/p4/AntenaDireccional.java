package es.upm.dit.prog.p4;


/**
 * Esta clase modela una antena de comunicaciones orientada en una direcci—n.
 * @author Juan C. Due–as
 */



public class AntenaDireccional implements Ubicado, Radiante {

    private double angulo;
    private double apertura;

    private double radio;
    private Coordenada posicion;

    /**
     * @param angulo çngulo (radianes) que forma el eje de la antena con
     * el eje de abcisas
     * @param apertura çngulo (radianes) de apertura de la antena respecto
     * al eje
     * @param radio Distancia m‡xima de cobertura de la antena
     * @param posicion Coordenadas del punto donde se encuentra situada
     * la antena
     */
    public AntenaDireccional(double angulo, double apertura,
            double radio, Coordenada posicion) {

        this.angulo = angulo;
        this.apertura = apertura;
        this.radio = radio;
        this.posicion = posicion;
    }

    /**
     * Consulta del valor del radio de la antena.
     * @return Valor actual del radio en radianes.
     */
    public double getRadio() {
        return radio;
    }
    /**
     * Asigna un nuevo valor al radio de la antena.
     * @param radio Nuevo valor en radianes del radio de la antena
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }
    /**
     * Consulta del punto (coordenadas) donde se encuentra la antena.
     * @return El valor actual de las coordenadas de la posici—n del antena.
     */
    public Coordenada getPosicion() {
        return posicion;
    }
    /**
     * Asigna un nuevo valor del punto donde se encuentra la antena.
     * @param p Nuevo valor de la posici—n de la antena
     */
    public void setPosicion(Coordenada p) {
        this.posicion = p;
    }

    /**
     * Consulta del valor del ‡ngulo de la antena.
     * @return Valor actual del ‡ngulo.
     */
    public double getAngulo() {
        return angulo;
    }

    /**
     * Asigna un nuevo valor del ‡ngulo de la antena.
     * @param angulo Nuevo valor del ‡ngulo.
     */
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    /**
     * Consulta del valor de la apertura de la antena.
     * @return Valor actual en radianes de la apertura.
     */
    public double getApertura() {
        return apertura;
    }

    /**
     * Asigna un nuevo valor de la apertura de la antena.
     * @param apertura Nuevo valor en radianes de apertura.
     */
    public void setApertura(double apertura) {
        this.apertura = apertura;
    }

    /**
     *<p>Calcula si el punto est‡ bajo la cobertura de la antena.</p>
     *
     * @return si est‡ en el ‡rea de cobertura
     * @param p Punto del que se quiere determinar su cobertura
     */
    public boolean enCobertura(Coordenada p) {

        double distancia = p.distancia(posicion);
        if (distancia < 0.01) {
            return true;
        }
        if (distancia > radio) {
            return false;
        }

        if (apertura == 2 * Math.PI) {
            return true;
        }

        Coordenada diferencia  = new Punto(p.getX() - posicion.getX(),
                                      p.getY() - posicion.getY());

        double anguloDiferencia = Math.atan2(diferencia.getX(), diferencia.getY());
        
        if (anguloDiferencia < 0) { 
            anguloDiferencia = (2 * Math.PI) + anguloDiferencia; 
            }

        double anguloMax = angulo + apertura / 2;
        if (angulo + apertura / 2 >= Math.PI * 2) {
            anguloMax = (angulo + apertura / 2) - (2 * Math.PI);
        }
        double anguloMin = angulo - apertura / 2;
        if (angulo - apertura / 2 < 0) {
            anguloMin = (2 * Math.PI) + (angulo - apertura / 2);
        }

        if (anguloMax >= anguloMin) {
            return (anguloDiferencia > anguloMin)
                && (anguloDiferencia < anguloMax);
        }

        return (anguloDiferencia < anguloMax) || (anguloDiferencia > anguloMin);

    }

    /**
     * Este m'etodo compara los atributos del objeto con el par'ametro del
     * m'etodo.
     * @param o Objeto con el que se quiere determinar la igualdad
     * @return Un valor booleano que indica si los elementos son o no
     * iguales
     */
    public boolean equals(Object o) {

        double error = 0.001;

        if (o == null) { return false; }
        if (o == this) { return true;  }
        if (!(o instanceof AntenaDireccional)) { return false; }

        AntenaDireccional antena = (AntenaDireccional) o;

        // Puede que falle si han cambiado los 'angulos sumando/restando 2Pi
        if (posicion.equals(antena.getPosicion())
            && (Math.abs(antena.getAngulo() - angulo) < error)
            && (Math.abs(antena.getApertura() - apertura) < error)
            && (Math.abs(antena.getRadio() - radio) < error)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Genera una tira de caracteres con los par‡metros de la antena.
     * @return Tira de caracteres que representa la antena.
     */

    public String toString() {
        return  angulo + ", " + apertura + ", " + radio + ", "
        + posicion.toString();
    }

}
