package once;


public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Personas Grego = new Personas("Grego", 0);
		Personas Nicolas = new Personas("Nicolas", 1);
		Personas Guille = new Personas("Guille", 2);
		Personas Adri = new Personas("Adri", 3);
		Personas Pedro = new Personas("Pedro", 4);
		Personas Gaypu = new Personas("Gaypu", 5);
		Personas Polo = new Personas("Polo", 6);
		Personas Eminem = new Personas("Eminem", 7);
		Personas Jeni = new Personas("Sara", 8);
		Personas Sheila= new Personas("Laura", 9);
		Personas Barbara = new Personas ("Ana", 10);
		
	
		Sorteo coche = new Sorteo();		
		
		coche.anadirPersonas(Grego);
		coche.anadirPersonas(Nicolas);
		coche.anadirPersonas(Guille);
		coche.anadirPersonas(Adri);
		coche.anadirPersonas(Pedro);
		coche.anadirPersonas(Gaypu);
		coche.anadirPersonas(Polo);
		coche.anadirPersonas(Eminem);
		coche.anadirPersonas(Jeni);
		coche.anadirPersonas(Sheila);
		coche.anadirPersonas(Barbara);	
		
		
		coche.imprimeBienvenida();
		coche.imprimePersonas();
		coche.sortear();
		coche.imprimeResultados();
		coche.imprimeDespedida();
				
		
	}

}
