package es.upm.dit.prog.p3;
/**
 * Clase que nos permite crear antenas, contar las antenas creadas,
 * ver si un punto est� en cobertura y si hay una antena en un punto 
 * en concreto 
 * 
 * @author Gregorio Mart�nez Luque
 * 
 */
public class Region {

    private final int X_MAX = 100;
    private final int Y_MAX = 100;
    private final int N_MAX_ANTENAS = 5;

    private AntenaDireccional[] laRegion = new AntenaDireccional[N_MAX_ANTENAS];
    private int nAntenas = 0;
    
    /**
     * Asigna atributos al array
     */
    public Region() {
        laRegion = new AntenaDireccional[N_MAX_ANTENAS];
        nAntenas = 0;
    }


    /**Este m�todo a�ade una antena a la regi�n.
     * 
     * @param unaAntena Antena que nos pasan como parametro y que a�ade una antena a la regi�n.
     * 
     * @throws Exception Tenemos 3 excepciones:
     * 1. Si la posici�n de la antena est� fuera del �rea de la regi�n.
     * 2. Si en la posici�n de la antena nueva ya hay una.
     * 3. Si la regi�n ya contiene el n�mero m�ximo de antenas.
     */
    public void anadirAntena(AntenaDireccional unaAntena)
    	     	 
		throws Exception {
    		Punto p1 = unaAntena.getPosicion();
    		
    		double x1 = p1.getX();
    		double y1 = p1.getY();
    		
    		//Primera excepci�n
        	   if(x1 > X_MAX || x1 < 0){
        		   throw new Exception ("Las coordenadas de la X no est�n en la regi�n");
        	   }
        	   if(y1 > Y_MAX || y1 < 0){
        		   throw new Exception ("Las coordenadas de la Y no est�n en la regi�n");
        	   }
        	   
        	 //Segunda excepci�n
        	   for(int i=0; i<nAntenas;i++){
          		  
				   Punto pi = laRegion[i].getPosicion();
				   double xi = pi.getX();
				   double yi = pi.getY();
        	   
        				if(xi+yi==x1+y1){ 
        			   throw new Exception ("Ya hay una antena en esa posici�n");
        				}
        	   }
        	   //Tercera excepci�n
        	   
        	   if(nAntenas>=5){
        		  throw new Exception("Ya hay 5 antenas creadas en esta regi�n"); 
        	   }
        	   else{
           	laRegion[nAntenas]= unaAntena;
           	laRegion[nAntenas++]=unaAntena;
        	   }   
}
        	   

    
    /**Retorna el n�mero de antenas creadas en la regi�n
     * 
     * @return Nos devuelve el n�mero de antenas que tenemos en la regi�n.
     */
    public int nAntenasEnRegion() {
        return nAntenas;
    }

    
    /** Comprueba si hay antena en un punto. Si la hay, devuelve el valor de la antena.
     *  En caso contrario, devuelve null.
     * 
     * @param unPunto Punto que nos pasan como parametro en el que queremos saber 
     * si hay una antena.
     * @return Devuelve el valor de la antena en caso de existir en ese punto.
     *  En otro caso, devuelve null.
     * @throws Exception Existe una excepci�n en caso de que el punto est� fuera de la regi�n.
     */
    public AntenaDireccional hayAntena(Punto unPunto) 
    
    throws Exception {
    	
	double x2 = unPunto.getX();
	double y2 = unPunto.getY();
	int i = 0;
    	
	// Primera excepci�n
		if(x2<0||x2>X_MAX||y2<0||y2>Y_MAX){
    		throw new Exception ("Fuera de la region");
    	}	
    	else{
    		for(i=0; i<nAntenas;i++){
    	  if(laRegion[i].getPosicion()==unPunto){    
    		  return laRegion[i];
    	  	}
    	}    	
    		  return null;      
    }
}
    
    /** Determina cuantas antenas tienen en su cobertura al punto que se pasa como
     * parametro.
     * 
     * @param unPunto Punto que nos proporcionan y en el cual queremos saber si hay cobertura
     * o no en ese punto y cuantas antenas le proporcionan cobertura.
     * @return Devuelve el n�mero de antenas en el punto dado.
     * @throws Exception Hay una excepci�n en el caso de que el punto que se pasa
     * est� fuera del �rea de la regi�n.
     */
    public int nAntenasConCobertura(Punto unPunto) throws Exception {
    	int i=0;
    	int num=0;
    	
    	double x3 = unPunto.getX();
		double y3 = unPunto.getY();
		
		//Primera excepci�n
    	if(x3<0||x3>X_MAX||y3<0||y3>Y_MAX){
    		throw new Exception ("Fuera de la region");
    	}
    	
    	for(i=0; i<nAntenas;i++){
      	  if(laRegion[i].enCobertura(unPunto)){    
      		  num++;
      	  }
      	  }return num;
    }

    
    /**
     * Genera una tira de caracteres con los par�metros de las antenas de la 
     * regi�n.
     * @return Tira de caracteres que representa la regi'on.
     */
    public String toString() {

        String antenasRegion = "";

        for (int i = 0; i < nAntenas; i++) {
            antenasRegion = antenasRegion + laRegion[i].toString() + "\n";
        }
        return antenasRegion;
    }


}
