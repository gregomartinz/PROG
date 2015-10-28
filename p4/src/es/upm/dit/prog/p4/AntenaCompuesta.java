package es.upm.dit.prog.p4;


import java.util.ArrayList;

/**
 * Esta clase modela una antena de telefon�a m�vil 
 * @author Gregorio Mart�nez Luque
 *
 */
public class AntenaCompuesta extends AntenaDireccional {

    
	private ArrayList<AntenaDireccional> antenas;
                
    /**
     * Contructor de la clase
     * 
     * @param posicion Coordenada en la que se situar� la antena.
     */
    public AntenaCompuesta(Coordenada posicion) {
        super (0.0, 0.0, 0.0, posicion);        
        antenas = new ArrayList<AntenaDireccional>();
    }
        
        
    /**
     * M�todo que a�ade una antena
     * 
     * @param a Antena a a�adir
     * @throws Exception Tenemos 3 excepciones
     * 1. Si la antena es nula
     * 2. Si ya existe una antena en ese punto
     * 3. Si la posic�n de la antena compuesta no es la misma que la antena direccional
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
     			throw new Exception ("Ya hay una antena ah�");
     		}
     	 }
    	 
    	 //tercera
    	 if(a.getPosicion() != getPosicion()){
    		 throw new Exception("No est� en la misma posici�n");
    	 }
    	 
    	 antenas.add(a);
     }
                
    /**
     *  M�todo que comprueba si en una coordenada existe cobertura o no
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
         * Genera una tira de caracteres con los par�metros de las antenas de la
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
