package multazos;

public class Registro {

	private String matricula;
	private double hora;
	private double kilometro;
	
	public Registro (String matricula, double hora, double kilometro){
		
		this.matricula = matricula;
		this.hora = hora;
		this.kilometro = kilometro;
	}
	
	public String getMatricula(){
		return matricula;
	}
	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	
	public double getHora (){
		return hora;
	}
	public void setHora (double hora){
		this.hora = hora;
	}
	
	public double getKilometro(){
		return kilometro;
	}
	public void setKilometro(double kilometro){
		this.kilometro = kilometro;
	}
}
