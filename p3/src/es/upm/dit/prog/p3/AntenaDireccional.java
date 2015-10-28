package es.upm.dit.prog.p3;


/**
 * Esta clase modela una antena de comunicaciones orientada en una direcci�n.
 * @author Juan C. Due�as
 */



public class AntenaDireccional {

    private double angulo;
    private double apertura;

    private double radio;
    private Punto posicion;

    /**
     * @param angulo �ngulo (radianes) que forma el eje de la antena con
     * el eje de abcisas
     * @param apertura �ngulo (radianes) de apertura de la antena respecto
     * al eje
     * @param radio Distancia m�xima de cobertura de la antena
     * @param posicion Coordenadas del punto donde se encuentra situada
     * la antena
     */
    public AntenaDireccional(double angulo, double apertura,
            double radio, Punto posicion) {

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
     * @return El valor actual de las coordenadas de la posici�n del antena.
     */
    public Punto getPosicion() {
        return posicion;
    }
    /**
     * Asigna un nuevo valor del punto donde se encuentra la antena.
     * @param p Nuevo valor de la posici�n de la antena
     */
    public void setPosicion(Punto p) {
        this.posicion = p;
    }

    /**
     * Consulta del valor del �ngulo de la antena.
     * @return Valor actual del �ngulo.
     */
    public double getAngulo() {
        return angulo;
    }

    /**
     * Asigna un nuevo valor del �ngulo de la antena.
     * @param angulo Nuevo valor del �ngulo.
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
     *<p>Calcula si el punto est� bajo la cobertura de la antena.</p>
     *
     * @return si est� en el �rea de cobertura
     * @param p Punto del que se quiere determinar su cobertura
     */
    public boolean enCobertura(Punto p) {

        double distancia = p.distancia(posicion);
        if (distancia < 0.01) {
            return true;
        }
        if (distancia > radio) {
            return false;
        }

        if (apertura == 2 * Math.PI) {
            //return true;
        }

        Punto diferencia  = new Punto(p.getX() - posicion.getX(),
                                      p.getY() - posicion.getY());
        double anguloDiferencia = diferencia.getAngulo();

        double anguloMax = angulo + apertura / 2;
        if (angulo + apertura / 2 >= Math.PI * 2) {
            anguloMax = (angulo + apertura / 2) - (2 * Math.PI);
        }
        double anguloMin = angulo - apertura / 2;
        if (angulo - apertura / 2 < 0) {
            anguloMin = (2 * Math.PI) + (angulo - apertura / 2);
        }

        if (anguloMax > anguloMin) {
            return (anguloDiferencia > anguloMin)
                && (anguloDiferencia < anguloMax);
        }

        return (anguloDiferencia < anguloMax) || (anguloDiferencia > anguloMin);

    }

    /**
     * Genera una tira de caracteres con los par�metros de la antena.
     * @return Tira de caracteres que representa la antena.
     */

    public String toString() {
        return  angulo + ", " + apertura + ", " + radio + ", "
        + posicion.toString();
    }

}