package ex�men;

public class Enumerados {
	
	public enum D�asSemana{Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo}

	public static void main(String[] args){
		D�asSemana unD�a=D�asSemana.Martes;
	
		System.out.println("Un d�a jodido es el " +unD�a);
		System.out.println("�l �ltimo d�a es el " +D�asSemana.Domingo);
}
}
