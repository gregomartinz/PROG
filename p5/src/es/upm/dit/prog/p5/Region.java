package es.upm.dit.prog.p5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.text.*;

import java.io.*;

/**
 * Esta clase permite definir un conjunto de antenas en una regi'on de un plano.
 * Facilita el c'alculo de la cobertura en un punto, al comprobar cuantas
 * antenas le tienen en su cobertura
 * @author Gregorio Martínez
 *
 */
public class Region {

    private final int X_MAX = 100;
    private final int Y_MAX = 100;
    public final int N_MAX_ANTENAS = 5;

    private ArrayList <Radiante> laRegion;
    private int nAntenas = 0;

    private int nAntenasLeidas   = 0;
    private int nAntenasCreadas  = 0;
    private int nAntenasErroneas = 0;

/**
 * Constructor de la clase.
 */
    public Region() {
        laRegion = new ArrayList<Radiante>();
        nAntenas = 0;
    }

    private boolean estaDentro(Coordenada unPunto) {
        return    unPunto.getX() >= 0
               && unPunto.getX() < X_MAX
               && unPunto.getY() >= 0
               && unPunto.getY() < Y_MAX;
     }

    /**
     * A~nade una antena a la regi'on.
     * @param unaAntena La antena a a~nadir
     * @throws NullPointerException Se eleva esta excepc'on si
     * el par'ametro que se pasa vale null
     * @throws IllegalArgumentException Se eleva esta excepc'on si:
     * - El punto est'a fuera del plano
     * - Ya se ha a~nadido el n'umero m'aximo de antenas
     * - Ya hay una antena en la posici'on de la antena pasada coo par'ametro
     */

    public void anadirAntena(Radiante unaAntena)
           throws NullPointerException, IllegalArgumentException {

        if (unaAntena == null) {
            throw new NullPointerException();
        }

        if (!estaDentro(unaAntena.getPosicion())) {
            throw new IllegalArgumentException("Fuera del plano");
        }

        if (nAntenas == N_MAX_ANTENAS) {
            throw new IllegalArgumentException("Limite de antenas alcanzado");
        }

        try {
           if (hayAntena(unaAntena.getPosicion()) != null) {
               throw new
                  IllegalArgumentException("Ya hay una antena en la posici'on");
           }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al obtener la posici'on");
        }

        laRegion.add(unaAntena);
        nAntenas++;
    }

/**
 * Determina con cuantas antenas tiene cobertura el punto dado.
 * @param unPunto El punto para analizar su cobertura
 * @return El n'umero de antenas con cobertura
 * @throws NullPointerException Se eleva esta excepc'on si
 * el par'ametro que se pasa vale null
 * @throws IllegalArgumentException Se eleva esta excepc'on si
 * el punto est'a fuera del plano
 */

    public int nAntenasConCobertura(Coordenada unPunto)
    throws NullPointerException, IllegalArgumentException {
        int nEnCobertura = 0;

        if (unPunto == null) {
            throw new NullPointerException("Par�metro con valor null");
        }

        if (!estaDentro(unPunto)) {
                throw new IllegalArgumentException("Fuera del plano");
            }

        for (Radiante objeto : laRegion) {
            if (objeto.enCobertura(unPunto)) {
                nEnCobertura++;
            }
        }
        return nEnCobertura;
    }

    /**
     * Devuelve el n'umero de antenas definidas en la reg'on.
     * @return N'umero de antenas en la regi'on
     */
    public int nAntenasEnRegion() {
        return nAntenas;
    }

    /**
     * Comprueba si hay una antena creada en un punto dado.
     * @param unPunto el punto donde hay que determinar si hay antena
     * @return Devuelve la antena, o null si no hay antena
     * @throws NullPointerException Se eleva esta excepc'on si
     * el par'ametro que se pasa vale null
     * @throws IllegalArgumentException Se eleva esta excepc'on si el
     * punto est'a fuera del plano
     */

    public Radiante hayAntena(Coordenada unPunto)
           throws NullPointerException, IllegalArgumentException {

        if (unPunto == null) {
            throw new NullPointerException("Par�metro con valor null");
        }

        if (!estaDentro(unPunto)) {
            throw new IllegalArgumentException("Fuera del plano");
        }

        for (Radiante objeto : laRegion) {
            if    (unPunto.getX() == objeto.getPosicion().getX()
                && unPunto.getY() == objeto.getPosicion().getY()) {
                return objeto;
            }
        }
        return null;
    }

    /**
     * Escribe en el fichero llamado "nombreFichero" las antenas de la región
     * 
     * @param nombreFichero Nombre del fichero que escribe
     * @throws NullPointerException Se eleva esta excepción si el parámetro que se pasa vale null
     * @throws IOException Se eleva esta excepción si el fichero no se puede crear
     */
    public void escribirFichero(String nombreFichero) 
        throws NullPointerException, IOException {

        
    	 File fichero = new File(nombreFichero);
    	 FileWriter writer = new FileWriter(fichero);
        //Primera excepción
        if (nombreFichero == null ) {
            throw new NullPointerException ("El nombre del fichero es nulo");
        }     
        
        //Segunda excepción
        if(!fichero.exists()){
            throw new IOException("El fichero no existe");
        }
        //Método
        
        String s = toString();
        writer.write(s);
        
        writer.close();
    }
   
    
    

    /**
     * Lee el fichero con el nombre "nombrefichero" en la carpeta por defecto
     * 
     * @param nombreFichero Nombre del fichero que se quiere leer
     * @throws NullPointerException Se eleva esta excepción si el parámetro que se pasa vale null
     * @throws IOException Se eleva esta excepción si el fichero no esxiste
     */
    public void leerFichero(String nombreFichero)
        throws NullPointerException, IOException {

        
    	 File fichero = new File (nombreFichero);
         Double[] array = new Double[5];
         Scanner entrada = new Scanner(fichero);
         //Primera excepción
         if (nombreFichero == null ) {
             throw new NullPointerException ("El nombre del fichero es nulo");
         }
         //Segunda excepción
         if(!fichero.exists()){
             throw new IOException("El fichero no existe");
         }        
         // Método
         etiqueta :
         while (entrada.hasNextLine()){
             int i = 0;
             Scanner linea = new Scanner (entrada.nextLine());

             while (linea.hasNextDouble()){
                 array[i] = linea.nextDouble();
                 i++;
             }

             if(i!=5){
                 return;
             }
             
             nAntenasLeidas++;
             Punto p = new Punto (array[3],array[4]);
             AntenaDireccional a = new AntenaDireccional (array[0], array[1], array[2], p);

             if (!estaDentro(p)){
                 nAntenasErroneas++;
                 continue etiqueta;
             }
             for (int j=0; j<array.length; j++){
                 if(array[j] == null){
                     continue;
                 }
             }
             try {
                 anadirAntena(a);
                 nAntenasCreadas++;
             }
             catch(Exception e){
                 nAntenasErroneas++;
             }
             continue etiqueta;
         }
         entrada.close();
     }

    

    /**
     * Borra la antena que se situe en la coordenada que se le pasa
     * 
     * @param posicion Coordenada de la que se quiere borrar la antena
     * @throws NullPointerException Se eleve esta excepción si el parámetro que se le pasa vale null
     * @throws IllegalArgumentException Se eleva esta excepción si:
     * - La coordenada está fuera de la región.
     * - No hay ninguna antena en la posición que se le pasa.
     */
    public void borrarAntena (Coordenada posicion)  
        throws NullPointerException, IllegalArgumentException{

    	Radiante rad = null;
    	
        //Primera excepción
        if (posicion == null) {
            throw new NullPointerException ("El parámetro apunta a null");
        }   	
        
        //Segunda excepción
        if (!estaDentro(posicion)){
            throw new IllegalArgumentException ("La coordenada está fuera de la región");
        }
      //Tercera Excepción
        for (Radiante objeto : laRegion){
            if (objeto.getPosicion().equals(posicion)){
                rad = objeto ;
            }
        }        
        if ( rad == null){
            throw new IllegalArgumentException("No hay ninguna antena en esta posici�n");
        }

        laRegion.remove(rad);
        nAntenas--;
    }
    

    /**
     * Este m'etodo retorna el n�mero de antenas le�das satisfactoriamente
     * de un fichero.
     * @return N'umero de antenas le'idas correctamente
     */
    public int nAntenasLeidas() {
        return nAntenasLeidas;
    }

    /**

     * Este m'etodo retorna el n'umero de antenas a~nadidas satisfactoriamente
     * le'idas de ficheros.
     * @return N'umero de antenas le'idas que se han creado correctamente
     */
    public int nAntenasCreadas() {
        return nAntenasCreadas;
    }

    /**
     * Este m'etodo retorna el n'umero de antenas a�adidas satisfactoriamente
     * que se han le'ido de un fichero.
     * @return N'umero de antenas er'oneas le'idas
     */
    public int nAntenasErroneas() {
        return nAntenasErroneas;
    }


    /**
     * Genera una tira de caracteres con los par�metros de las antenas de la
     * regi'on.
     * @return Tira de caracteres que representa la regi'on.
     */

    public String toString() {

        String antenasRegion = "";

        for (Radiante objeto : laRegion) {
            antenasRegion = antenasRegion + objeto.toString() +"\n"  + "\n";
        }
        return antenasRegion;
    }

}