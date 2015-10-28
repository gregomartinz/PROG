package es.upm.dit.prog.p4;

/**
 * Esta clase genera una antena omnidireccional en la región
 * @author Gregorio Martínez Luque
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
         *  Método que comprueba si un punto p está en cobertura o no
         */
	public boolean enCobertura(Coordenada p) {
		
	   if(posicion.distancia(p)<radio){
		   return true;
	   }  
	  
	   return false;
	}
	
	    
	
}
