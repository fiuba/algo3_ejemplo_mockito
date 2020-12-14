package fiuba.algo3.ejemploMockito.modelo;

public class Conductor {

	private IVehiculo vehiculo;
	
	public Conductor (IVehiculo vehiculo){
		this.vehiculo = vehiculo;
	}
	
	public boolean maniobraFrenadoPacifica(boolean conductorOfendido){
		
		if (conductorOfendido){
			insultar();
			return vehiculo.frenar() && vehiculo.tocarBocina();
		}
		
		return vehiculo.frenar();
	}
	
	public void insultar(){
		System.out.println("La re ...%&&/(/$#$% ");
	}
}
