package aquinas;

public class Pruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Sorteo s20 = new Sorteo(20);
		Sorteo s19 = new Sorteo(19);
		Sorteo s18 = new Sorteo(18);
		Sorteo s17 = new Sorteo(17);
		Sorteo s16 = new Sorteo(16);
		Sorteo s15 = new Sorteo(15);
		Sorteo s14 = new Sorteo(14);
		Sorteo s13 = new Sorteo(13);
		Sorteo s12 = new Sorteo(12);
		Sorteo s11 = new Sorteo(11);
		Sorteo s10 = new Sorteo(10);
		Sorteo s9 = new Sorteo(9);
		Sorteo s8 = new Sorteo(8);
		Sorteo s7 = new Sorteo(7);
		Sorteo s6 = new Sorteo(6);
		Sorteo s5 = new Sorteo(5);
		Sorteo s4 = new Sorteo(4);
		Sorteo s3 = new Sorteo(3);
		Sorteo s2 = new Sorteo(2);
		
		Torre t = new Torre();
		t.toString();
		
		
		
		Habitacion cientoUno = new Habitacion (101, "Ciento uno");
		
		Personas pabloCruces = new Personas ("Pablo Cruces", 12);
		Personas burbujita = new Personas ("Germ�n Orgueira", 3);
		Personas pbloCruces = new Personas ("Po Cruces", 12);
		Personas brbujita = new Personas ("Ger Orgueira", 3);
		Personas a = new Personas ("ces", 12);
		Personas b = new Personas ("ira", 3);
		Personas c = new Personas ("Poya", 12);
		Personas d = new Personas ("Ge", 3);
		
		Homologia pabloburbu = new Homologia (pabloCruces,burbujita);
		Homologia competitiva = new Homologia (pbloCruces,brbujita);
		Homologia as = new Homologia (a,b);
		Homologia marca = new Homologia (c,d);
		
		s15.anadirHomolog�a(competitiva);
		s15.anadirHomolog�a(pabloburbu);
		s15.anadirHomolog�a(as);
		s15.anadirHomolog�a(marca);
		
		
		
			s15.sortear();
			s15.imprimeBienvenida();
			s15.imprimeHomologosEnSorteo();
			s15.imprimeResultados();
			s15.imprimeDespedida();
		
		
		
		
		
	}

}
