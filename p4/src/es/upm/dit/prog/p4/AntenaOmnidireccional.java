package es.upm.dit.prog.p4;

/**
 * Esta clase genera una antena omnidireccional en la regi�n
 * @author Gregorio Mart�nez Luque
 *
 */

public class AntenaOmnidireccional extends AntenaDireccional implements Ubicado{

    
	private double radio;
	private Coordenada posicion;

	/**
	 * Constructor de la clase
	 * 
	 * @param radio Alcance de la antena creada.
	 * @param posicion Coordenada en la que se genera la antena.
	 */
	public AntenaOmnidireccional(double radio, Coordenada posicion) {
            super(0, Math.PI * 2, radio, posicion);
            this.radio    = radio;
            this.posicion = posicion;
	}
	
	
        /**
         *  M�todo que comprueba si un punto p est� en cobertura o no
         */
	public boolean enCobertura(Coordenada p) {
		
	   if(posicion.distancia(p)<radio){
		   return true;
	   }  
	  
	   return false;
	}
	
	    
	
}
