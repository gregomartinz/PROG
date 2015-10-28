package exámen;

public class Enumerados {
	
	public enum DíasSemana{Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo}

	public static void main(String[] args){
		DíasSemana unDía=DíasSemana.Martes;
	
		System.out.println("Un día jodido es el " +unDía);
		System.out.println("Él último día es el " +DíasSemana.Domingo);
}
}
