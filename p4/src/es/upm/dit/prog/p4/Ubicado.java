package es.upm.dit.prog.p4;

/**
 * Este interfaz define clases que pueden ubicarse en una coordenada concreta.
 * @version 1.0
 * @author Alejandro Alonso
 */
public interface Ubicado {
    
    /**
     * Este método devuelve las coordenadas de la posici'on del elemento.
     * @return Objeto de la clase Coordenada en el que se encuentra el elemento
     */
     public Coordenada getPosicion();
}
