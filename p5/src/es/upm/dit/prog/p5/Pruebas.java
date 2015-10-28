package es.upm.dit.prog.p5;

import java.io.IOException;

public class Pruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	       Punto p1 = new Punto (2,2);
	       Punto p2 = new Punto (10,10);
	       Punto p3 = new Punto (20,20);
	       Punto p4 = new Punto (30,30);
	       Punto p5 = new Punto (101,101);
	       Punto p6 = new Punto (40,40);
	       Punto p7 = new Punto (50,50);
	       Punto p9 = new Punto (102,102);
	       AntenaDireccional a1 = new AntenaDireccional (1,1,1,p1);
	       AntenaDireccional a2 = new AntenaDireccional (1,1,1,p2);
	       AntenaDireccional a3 = new AntenaDireccional (1,1,1,p3);
	       AntenaDireccional a3_1= new AntenaDireccional(1,1,3,p3);
	       AntenaDireccional a4 = new AntenaDireccional (1,1,1,p4);
	       AntenaDireccional a5 = new AntenaDireccional (1,1,1,p4);
	       AntenaDireccional a6 = new AntenaDireccional (1,1,1,p9);
	       AntenaDireccional a7 = new AntenaDireccional (1,1,1,p6);
	       AntenaDireccional a8 = new AntenaDireccional (1,1,1,p7);

	       Region r = new Region();
	         
	       
	       try {
			r.leerFichero("f4.txt");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			r.escribirFichero("hola1.txt");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(r.toString());
		System.out.println("Se han leido " +r.nAntenasLeidas() +" antenas");
		System.out.println("Se han creado " +r.nAntenasCreadas() +" antenas");
		System.out.println("Un total de  " +r.nAntenasErroneas() +" antenas erroneas");
		//System.out.println(r.nAntenasLeidas());
		
	}

}
