package once;
import java.util.ArrayList;
import java.util.Random;

public class Sorteo {
	
	private ArrayList <Personas> gente;
	private ArrayList <Personas> premiados;
	private Random aleatorio;
	private Random semilla;
	public Sorteo (){
		gente = new ArrayList<Personas>();
		premiados = new ArrayList<Personas>();
		semilla = new Random ();
		aleatorio = new Random (semilla.nextInt());
	}
	
	public void anadirPersonas(Personas p){
		gente.add(p);
	}
	
	public void sortear(){
		
		int contador = 4;
		for(;;){
			int i = aleatorio.nextInt(gente.size());
			if(!premiados.contains(gente.get(i))){
				premiados.add(gente.get(i));
			}
			else{
				continue;
			}			
			if(premiados.size()==contador){
				return;
			}		
		}
	}
	public void imprimeResultados(){
		
		System.out.println("Comienzan en 3...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println(" 2...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println(" 1...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Los ganadores son:");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		for(Personas afortunados : premiados){		
			
			System.out.println(afortunados.toString());
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
			}
		}
	}
	public void imprimePersonas(){
		System.out.println("Los participantes son:");
		
		for(Personas objeto : gente){
			System.out.println(objeto.toString());
			try {
				Thread.sleep(500);
			}catch (InterruptedException e) {
			}
		}
		System.out.println("\n");
	}
	
	public void imprimeBienvenida(){
		
		System.out.println("Primera edición del sorteo");
		System.out.println("================================");
	}
	
	public void imprimeDespedida(){
		System.out.println("*****************************************");
		System.out.println("=========================================");
	}
	
	
	
	public String toString() {
        String resultado = "";        
        return resultado;
    }

}