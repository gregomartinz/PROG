package aquinas;

import java.util.ArrayList;

public class Torre  {

	private ArrayList<HomHab> torre;
	
	public Torre () {

		
		torre = new ArrayList<HomHab>();
			
	}
	
	public ArrayList<HomHab> getTorre (){
		
		return torre;
		
	}
	
	public void anadirHomHab(HomHab h){
				
		if (h.getH1() != h.getH2()){		
			torre.add(h);
		}
	}
	
	public void borrarHomHab(HomHab h){
		if(torre.contains(h)){
			torre.remove(h);
		}
		else{
			System.out.println("Está habitación no está creada");
		}
	}
	
	
	public void imprimirTorre(){
		System.out.println(toString());
	}

	public String toString(){
		
		String s = "";
		String d = "";
		int contador=1;
		for(HomHab objeto : torre){
			s = objeto.toString();
			System.out.println("Homología numero " + contador +"  "+s);
			contador++;
		}
		return d;
	}
	
	public void setTorre(ArrayList<HomHab> torre){
		this.torre = torre;
		
	}
}
