package multazos;

public class GestorDeMultas {

	public static final double MAX_VEL = 120;
	private static final int TAMANO = 100;
	private Registro[] tabla;
	
	public GestorDeMultas(){
		
		tabla = new Registro[TAMANO];
	}
	
	public void entrada(Registro reg){
		
		int mas_antiguo = 0;
		
		for(int i = 0; i<tabla.length;i++){
			if(tabla[i]==null){
				tabla [i] = reg;
				return;
			}
			if(tabla[mas_antiguo] != null && tabla[i].getHora() < tabla[mas_antiguo].getHora()){
				mas_antiguo = i;
			}
		}
		tabla[mas_antiguo] = reg;
	}
	
	public void salida (Registro salida){
		Registro entrada = null;
		
		for(int i = 0;i<tabla.length;i++){
			if(tabla[i] != null && tabla[i].getMatricula().equals(salida.getMatricula())){
				
				if(entrada == null || entrada.getHora() < tabla[i].getHora()){
					entrada = tabla[i];
				}
				tabla[i] = null;
			}			
		}
		if(entrada != null){
			double distancia = salida.getKilometro()-entrada.getKilometro();
			double tiempo = salida.getHora()-entrada.getHora();
			double velocidad = distancia /tiempo;
			
			if(velocidad > MAX_VEL){
				System.out.print("Multa: " + salida.getMatricula());
				System.out.print(" Velocidad " + velocidad);
				System.out.print(" entre " + entrada.getHora() +" y " +salida.getHora() + " horas, ");
				System.out.print("entre kms " +entrada.getKilometro() + " y " +salida.getKilometro());
				System.out.println();
				
			}
		}
		
	}
	
}
