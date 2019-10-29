package test;

import org.junit.Assert;
import org.junit.Test;

import mocks.VehiculoMock;
import model.Conductor;

public class ConductorMockPropioTest {

	@Test
	public void elConductorLaBardeo() {

		VehiculoMock vehiculoMock = new VehiculoMock();
		Conductor conductor = new Conductor(vehiculoMock);
		
		boolean ofendido = true;
		
		Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));
		Assert.assertEquals(1,vehiculoMock.getCantidadBocinazos());
		Assert.assertEquals(1, vehiculoMock.getCantidadPisadasAlFreno());
	}
	
	
	@Test
	public void elConductorEstaTranquilo() {

		VehiculoMock vehiculoMock = new VehiculoMock();
		Conductor conductor = new Conductor(vehiculoMock);
		
		boolean ofendido = false;
		
		Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));
		Assert.assertEquals(0,vehiculoMock.getCantidadBocinazos());
		Assert.assertEquals(1, vehiculoMock.getCantidadPisadasAlFreno());
	}

}
