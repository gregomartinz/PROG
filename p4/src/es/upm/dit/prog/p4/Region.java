package es.upm.dit.prog.p4;

import java.util.ArrayList;

/**
 * Clase que genera una región.
 * @author Grego
 * 
 */
public class Region {

    
    private final int X_MAX = 100;
    private final int Y_MAX = 100;
    private final int N_MAX_ANTENAS = 5;

    private ArrayList<Radiante> laRegion;
    private int nAntenas = 0;

 
    public Region() {
        laRegion = new ArrayList<Radiante>();
        nAntenas = 0;
    }


    /**
     * Método que añade una antena
     * 
     * @param unaAntena Antena a añadir a la región
     * @throws Exception 
     * Existen 4 excepciones:
     * 1. La antena es nula
     * 2. La antena está fuera de la región
     * 3. Ya hay una antena ahí
     * 4. La región está llena
     */
    public void anadirAntena(Radiante unaAntena)
    
    	throws Exception {
    	
    	//Primera excepción
    	if(unaAntena==null){
    		throw new Exception ("El parámetro apunta a null");
    	}
    	
    	//Segunda excepción	
    	if(unaAntena.getPosicion().getX()>(X_MAX-1)||unaAntena.getPosicion().getX()<0||unaAntena.getPosicion().getY()>(Y_MAX-1)||unaAntena.getPosicion().getY()<0){
    		throw new Exception ("La coordenada X y/o Y está fuera");
    	}
    	
    	
    	//Tercera excepción
    	for(Radiante p: laRegion){
    		if(p.getPosicion()==unaAntena.getPosicion()){
    			throw new Exception ("Ya hay una antena ahí");
    		}
    	}
    	
    	//Cuarta excepción
    	if(nAntenas==N_MAX_ANTENAS){
    		throw new Exception ("Ya no caben más antenas");
    	}
    	
    	laRegion.add(unaAntena);
    	nAntenas++;
    }

    /**
     * Método que devuelve el número de antenas que hay en la región
     * 
     * @return Devuelve el número de antenas que hay en la región.
     */
    public int nAntenasEnRegion() {
        return nAntenas;
    }

    /**
     * Método que comprueba si hay alguna antena en un punto
     * 
     * @param unPunto Coordenada introducida con la que se compara la posición de la antena
     * @return Devuelve la coordenada en la que está el punto, o null en el caso no encontrarse
     * en la región
     * @throws Exception
     * Existen 2 excepciones:
     * 1. El punto es nulo
     * 2. El punto no está en la región
     */
    public Radiante hayAntena(Coordenada unPunto) 
           throws Exception {
    	
    	//Primera excepción
    	if(unPunto==null){
    		throw new Exception ("El parametro apunta a null");
    	}
    	
    	//Segunda excepción
    	if(unPunto.getX()<0||unPunto.getX()>(X_MAX-1)||unPunto.getY()<0||unPunto.getY()>(Y_MAX-1)){
    		throw new Exception ("El punto no está en la región");
    	}    	
    		else{
    			for(Radiante p:laRegion){
    				if(p.getPosicion()==unPunto){
    					return p;
    			}    				
    		}
    	}return null;
        
    }
    
    /**
     * Método que comprueba el numero de antena con cobertura en un punto
     * 
     * @param unPunto Coordenada en la que se quiere saber si hay cobertura
     * @return El numero de antenas que proporcionan cobertura
     * @throws Exception
     * Existen 2 excepciones:
     * 1. El punto es nulo
     * 2. El punto no está en la región
     */
    public int nAntenasConCobertura(Coordenada unPunto)
        
    	throws Exception {
    	
    	//Atributos
    	int num = 0;
    	
    	//Primera excepción
    	
    	if(unPunto==null){
    		throw new Exception ("El parámetro apunta a null");
    	}
    	
    	
    	//Segunda excepción
    	
    	if(unPunto.getX()<0||unPunto.getX()>(X_MAX-1)||unPunto.getY()<0||unPunto.getY()>(Y_MAX-1)){
    		throw new Exception ("El punto no está en la región");
    	}    	
    	else{
    		for(Radiante p:laRegion){
    			if(p.enCobertura(unPunto)){
    				num++;
    			}    				
    		}
    	}return num;
    	
    }

    
    /**
     * Método que calcula la velocidad de transmisión WIFI
     * 
     * @param unPunto Coordenada en la que se quiere calcular la velocidad
     * @return La velocidad de transmisión
     * @throws Exception
     * Existen 2 excepciones:
     * 1. El punto es nulo
     * 2. El punto no está en la región
     */
    public int velocidadTransmisionWIFI(Coordenada unPunto)
    throws Exception {
    	
    	//Atributos
    	int velocidad = 0;
    	
    	//Primera excepción
    	if(unPunto==null){
    		throw new Exception ("El parámetro apunta a null");
    	}
    	
    	//Segunda excepción
    	if(unPunto.getX()<0||unPunto.getX()>(X_MAX-1)||unPunto.getY()<0||unPunto.getY()>(Y_MAX-1)){
    		throw new Exception ("El punto no está en la región");
    	}
    	for(Radiante p: laRegion){
    		
    		if(p instanceof RouterWIFI){
    			RouterWIFI router=(RouterWIFI)p;
    			if(router.velocidadTransmisionWIFI(unPunto) > velocidad){
    				velocidad = router.velocidadTransmisionWIFI(unPunto);
    			}
     		}
       	}
    	return velocidad;
    	
    }

    
    /**
     * Genera una tira de caracteres con los par‡metros de las antenas de la 
     * regi'on.
     * @return Tira de caracteres que representa la regi'on.
     */
    public String toString() {

        String antenasRegion = "";
 
        for (Radiante objeto: laRegion) {
            antenasRegion = antenasRegion + objeto.toString() + "\n";
        }
        return antenasRegion;

    }


}
