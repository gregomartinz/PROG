package es.upm.dit.prog.p4;


import java.util.ArrayList;

/**
 * Esta clase modela una antena de telefonía móvil 
 * @author Gregorio Martínez Luque
 *
 */
public class AntenaCompuesta extends AntenaDireccional {

    
	private ArrayList<AntenaDireccional> antenas;
                
    /**
     * Contructor de la clase
     * 
     * @param posicion Coordenada en la que se situará la antena.
     */
    public AntenaCompuesta(Coordenada posicion) {
        super (0.0, 0.0, 0.0, posicion);        
        antenas = new ArrayList<AntenaDireccional>();
    }
        
        
    /**
     * Método que añade una antena
     * 
     * @param a Antena a añadir
     * @throws Exception Tenemos 3 excepciones
     * 1. Si la antena es nula
     * 2. Si ya existe una antena en ese punto
     * 3. Si la posicón de la antena compuesta no es la misma que la antena direccional
     */
     public void anadirAntena(AntenaDireccional a) 
     throws Exception {
    	 
         //primera
    	 if (a==null){
    		 throw new Exception("La antena es nula");
    	 }
    	 
    	 //segunda
    	 for(AntenaDireccional p: antenas){
     		if(p.equals(a)){
     			throw new Exception ("Ya hay una antena ahí");
     		}
     	 }
    	 
    	 //tercera
    	 if(a.getPosicion() != getPosicion()){
    		 throw new Exception("No está en la misma posición");
    	 }
    	 
    	 antenas.add(a);
     }
                
    /**
     *  Método que comprueba si en una coordenada existe cobertura o no
     */
        public boolean enCobertura(Coordenada p) {

            for(AntenaDireccional ad:antenas){
            	if(ad.enCobertura(p)){
            		return true;
            	}
            }
            return false;
        }
        
        /**
         * Genera una tira de caracteres con los par‡metros de las antenas de la
         * regi'on.
         * @return Tira de caracteres que representa la regi'on.
         */
        
        public String toString() {
            
            String antenasSalida = "";

            for (AntenaDireccional antena: antenas) {
                antenasSalida = antenasSalida + antena.toString() + "\n";
            }
            return antenasSalida;
        }

}
