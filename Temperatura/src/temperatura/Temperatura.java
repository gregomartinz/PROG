package temperatura;

public class Temperatura {

	public double temperatura;
	public double maxima;
	public double minima;
	public int incremento;
		
public Temperatura(double t1){
	temperatura = t1;
	}
public double getTemperatura() {	
	Math.min(temperatura, maxima);
	Math.max(temperatura, minima);
	return temperatura;	
	}
public double setTemperatura(double t1) {
	t1 = Math.min(temperatura, maxima);
	t1 = Math.max(temperatura, minima);
	return temperatura = t1;	
	}
//Aumentar temperatura
public double sube() {
	return Math.min(maxima, incremento + temperatura);
	}
//Reducir temperatura
public double baja() {
	return Math.max(minima,temperatura - incremento);	
	}
}