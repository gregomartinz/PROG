package es.upm.dit.prog.p4;

import java.util.ArrayList;

/**
 * Clase que genera una regi�n.
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
     * M�todo que a�ade una antena
     * 
     * @param unaAntena Antena a a�adir a la regi�n
     * @throws Exception 
     * Existen 4 excepciones:
     * 1. La antena es nula
     * 2. La antena est� fuera de la regi�n
     * 3. Ya hay una antena ah�
     * 4. La regi�n est� llena
     */
    public void anadirAntena(Radiante unaAntena)
    
    	throws Exception {
    	
    	//Primera excepci�n
    	if(unaAntena==null){
    		throw new Exception ("El par�metro apunta a null");
    	}
    	
    	//Segunda excepci�n	
    	if(unaAntena.getPosicion().getX()>(X_MAX-1)||unaAntena.getPosicion().getX()<0||unaAntena.getPosicion().getY()>(Y_MAX-1)||unaAntena.getPosicion().getY()<0){
    		throw new Exception ("La coordenada X y/o Y est� fuera");
    	}
    	
    	
    	//Tercera excepci�n
    	for(Radiante p: laRegion){
    		if(p.getPosicion()==unaAntena.getPosicion()){
    			throw new Exception ("Ya hay una antena ah�");
    		}
    	}
    	
    	//Cuarta excepci�n
    	if(nAntenas==N_MAX_ANTENAS){
    		throw new Exception ("Ya no caben m�s antenas");
    	}
    	
    	laRegion.add(unaAntena);
    	nAntenas++;
    }

    /**
     * M�todo que devuelve el n�mero de antenas que hay en la regi�n
     * 
     * @return Devuelve el n�mero de antenas que hay en la regi�n.
     */
    public int nAntenasEnRegion() {
        return nAntenas;
    }

    /**
     * M�todo que comprueba si hay alguna antena en un punto
     * 
     * @param unPunto Coordenada introducida con la que se compara la posici�n de la antena
     * @return Devuelve la coordenada en la que est� el punto, o null en el caso no encontrarse
     * en la regi�n
     * @throws Exception
     * Existen 2 excepciones:
     * 1. El punto es nulo
     * 2. El punto no est� en la regi�n
     */
    public Radiante hayAntena(Coordenada unPunto) 
           throws Exception {
    	
    	//Primera excepci�n
    	if(unPunto==null){
    		throw new Exception ("El parametro apunta a null");
    	}
    	
    	//Segunda excepci�n
    	if(unPunto.getX()<0||unPunto.getX()>(X_MAX-1)||unPunto.getY()<0||unPunto.getY()>(Y_MAX-1)){
    		throw new Exception ("El punto no est� en la regi�n");
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
     * M�todo que comprueba el numero de antena con cobertura en un punto
     * 
     * @param unPunto Coordenada en la que se quiere saber si hay cobertura
     * @return El numero de antenas que proporcionan cobertura
     * @throws Exception
     * Existen 2 excepciones:
     * 1. El punto es nulo
     * 2. El punto no est� en la regi�n
     */
    public int nAntenasConCobertura(Coordenada unPunto)
        
    	throws Exception {
    	
    	//Atributos
    	int num = 0;
    	
    	//Primera excepci�n
    	
    	if(unPunto==null){
    		throw new Exception ("El par�metro apunta a null");
    	}
    	
    	
    	//Segunda excepci�n
    	
    	if(unPunto.getX()<0||unPunto.getX()>(X_MAX-1)||unPunto.getY()<0||unPunto.getY()>(Y_MAX-1)){
    		throw new Exception ("El punto no est� en la regi�n");
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
     * M�todo que calcula la velocidad de transmisi�n WIFI
     * 
     * @param unPunto Coordenada en la que se quiere calcular la velocidad
     * @return La velocidad de transmisi�n
     * @throws Exception
     * Existen 2 excepciones:
     * 1. El punto es nulo
     * 2. El punto no est� en la regi�n
     */
    public int velocidadTransmisionWIFI(Coordenada unPunto)
    throws Exception {
    	
    	//Atributos
    	int velocidad = 0;
    	
    	//Primera excepci�n
    	if(unPunto==null){
    		throw new Exception ("El par�metro apunta a null");
    	}
    	
    	//Segunda excepci�n
    	if(unPunto.getX()<0||unPunto.getX()>(X_MAX-1)||unPunto.getY()<0||unPunto.getY()>(Y_MAX-1)){
    		throw new Exception ("El punto no est� en la regi�n");
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
     * Genera una tira de caracteres con los par�metros de las antenas de la 
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
