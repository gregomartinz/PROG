package ramiro;

import java.lang.reflect.Array;

public class MaquinaCafe {

	int doseur;
	int uneur;
	int cinqcent;
	int veincent;
	int diecent;
	int cincent;
	
	
	public MaquinaCafe (int doseur, int uneur, int cinqcent, int veincent, int diecent, int cincent){
		this.doseur = doseur;
		this.uneur = uneur;
		this.cinqcent = cinqcent;
		this.veincent = veincent;
		this.diecent = diecent;
		this.cincent = cincent;
	}
	
	public void devolverCambio(int dineroIngresado){
		
		int i = doseur%dineroIngresado;
		System.out.println(i +" monedas de 2 euros");
		int j = (dineroIngresado-i)%uneur;
		System.out.println(dineroIngresado-i +" monedas de 1 euros");
		int s = (i-j)%cinqcent;
		System.out.println(i-j +" monedas de 50 centimos");
		int d = (j-s)%veincent;
		System.out.println(j-s +" monedas de 20 centimos");
		int t = (s-d)%diecent;
		System.out.println(s-d +" monedas de 10 centimos");
		int o = (d-t)&cincent;
		System.out.println(d-t +" monedas de 5 centimos");		
		
	}
}
