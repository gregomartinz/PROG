package es.upm.dit.prog.p4;

/**
 * Esta interfaz define clases que de elementos radiante que se coportan como
 * routers WIFI y puede calcularse su velocidad de transmisi—n
 * @version 1.0
 * @author Alejandro Alonso
 */
public interface RouterWIFI extends Radiante {

    /**
     * M'etodo que permite calcular la velocidad de transmisi—n disponible en
     * un punto.
     * @param p Coordenada en la que se debe determinar la velocidad disponible
     * @return Valor de la velocidad de transmisi—n
     */
    int velocidadTransmisionWIFI(Coordenada p) throws Exception;
}
