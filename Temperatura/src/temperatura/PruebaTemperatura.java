package temperatura;

public class PruebaTemperatura {

public static void main(String[] args) {
	
	Temperatura t1 = new Temperatura(70);
	t1.temperatura=25;
	t1.maxima=70;
	t1.minima=0;
	t1.incremento=4;
	
	
	
	t1.setTemperatura(8);
	System.out.println(t1.getTemperatura());
	System.out.println(t1.sube());
	System.out.println(t1.baja());
	
	
	
	
}	

	
}

