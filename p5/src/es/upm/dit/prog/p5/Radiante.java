package es.upm.dit.prog.p5;

/**
 * Esta interfaz define clases ubicadas que son capaces de emitir y recibir. 
 * @version 1.0
 * @author Alejandro Alonso
 */
public interface Radiante extends Ubicado{

    /**
     * Este m'etodo determina si una coordenada tiene cobertura de un objeto
     * radiante
     * @param c Coordenada en la que se debe determinar la velocidad disponible
     * @return  Informa sobre la disponibilidad de cobertura
     */
    boolean enCobertura(Coordenada c);
}
