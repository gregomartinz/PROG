package aquinas;

import java.util.*;

public class Homologia {

	private Personas hom1;
	private Personas hom2;
	private int puntosHomologia;
	private ArrayList <Habitacion> habitaciones;
	
	
	public Homologia (Personas hom1, Personas hom2){
		
		this.hom1=hom1;
		this.hom2=hom2;
		this.puntosHomologia=hom1.getPuntos()+hom2.getPuntos();
		habitaciones = new ArrayList<Habitacion>();
		
	}
	
	public Personas getHom1(){
		return hom1;
	}
	public void setHom1(Personas hom1){
		this.hom1=hom1;
	}
	
	public Personas getHom2(){
		return hom2;
	}
	public void setHom2(Personas hom2){
		this.hom2=hom2;
	}
	
	public int getPuntosHomologia(){
		return puntosHomologia;
	}
	public void setPuntosHomologia(int puntosHomologia){
		this.puntosHomologia=puntosHomologia;
	}
	
	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones){
		this.habitaciones=habitaciones;
	}
	
	
	public String toString (){
		String s="";
		s=hom1.toString()+"     "+hom2.toString()+"  = " +puntosHomologia +"\n";
		return s;
	}
}
