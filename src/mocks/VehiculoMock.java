package mocks;

import model.IVehiculo;

public class VehiculoMock implements IVehiculo {
	
	private int cantidadBocinazos = 0;
	private int cantidadPisadasAlFreno = 0;

	@Override
	public boolean frenar() {
		cantidadPisadasAlFreno++;
		return true;
	}

	@Override
	public boolean tocarBocina() {
		cantidadBocinazos++;
		return true;
	}

	public int getCantidadBocinazos() {
		return cantidadBocinazos;
	}

	public int getCantidadPisadasAlFreno() {
		return cantidadPisadasAlFreno;
	}
}
