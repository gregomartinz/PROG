package aquinas;

public class Habitacion {
	
	private String nombre;
	private int num;
	
	public Habitacion (int num,String nombre ){
	
		this.num = num;
		this.nombre = nombre;
		
	}
	
	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num=num;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		
		this.nombre = nombre;
		
	}
	
	public String toString(){
		
		String s = "";
		s = getNombre() + "    " + getNum();
		return s;
	}
	}

