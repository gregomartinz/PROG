package aquinas;

public class Personas {
	
	private String nombre;

	private int puntos;

	
	public Personas (String nombre, int puntos){
		this.nombre=nombre;
		
		this.puntos=puntos;
		
	}
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre (String nombre){
		this.nombre=nombre;
	}
	
	public int getPuntos(){
		return puntos;
	}
	public void setPuntos(int puntos){
		this.puntos=puntos;
	}
	public String toString() {

        String resultado = "";
        
        resultado =  getNombre() + "---->Numero de Puntos:  " +getPuntos();
        
        return resultado;
    }
}
