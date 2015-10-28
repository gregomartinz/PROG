package gregomartinz;

public class Particula implements Onda, Corpusculo{

	private double longitud;
	private double masa;
	private double velocidad;
	
	public Particula(double longitud, double masa, double velocidad){
		
		this.longitud = longitud;
		this.masa = masa;
		this.velocidad = longitud;
	}
	
	public double getLongitud(){
		return longitud;
	}
	public double getMasa(){
		return masa;
	}
	public double getVelocidad(){
		return velocidad;
	}
}
