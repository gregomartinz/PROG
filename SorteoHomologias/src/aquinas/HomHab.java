package aquinas;

public class HomHab {

	private Habitacion h1;
	private Habitacion h2;
	
	public HomHab(Habitacion h1, Habitacion h2){
		
		this.h1=h1;
		this.h2=h2;
	}
	
	public Habitacion getH1(){
		return h1;
	}
	public void setH1(Habitacion h1){
		this.h1=h1;
	}
	
	public Habitacion getH2(){
		return h2;
	}
	public void setH2(Habitacion h2){
		this.h2=h2;
	}
	
	public String toString(){
		String s = "";
		s = h1.toString() +"  " + h2.toString();
		return s;
	}
	
}
