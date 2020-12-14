package fiuba.algo3.ejemploMockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fiuba.algo3.ejemploMockito.modelo.Conductor;

public class ConductorMockPropioTest {

	@Test
	public void elConductorLaBardeo() {

		VehiculoMock vehiculoMock = new VehiculoMock();
		Conductor conductor = new Conductor(vehiculoMock);
		
		boolean ofendido = true;
		
		assertTrue(conductor.maniobraFrenadoPacifica(ofendido));
		assertEquals(1,vehiculoMock.getCantidadBocinazos());
		assertEquals(1, vehiculoMock.getCantidadPisadasAlFreno());
	}
	
	
	@Test
	public void elConductorEstaTranquilo() {

		VehiculoMock vehiculoMock = new VehiculoMock();
		Conductor conductor = new Conductor(vehiculoMock);
		
		boolean ofendido = false;
		
		assertTrue(conductor.maniobraFrenadoPacifica(ofendido));
		assertEquals(0,vehiculoMock.getCantidadBocinazos());
		assertEquals(1, vehiculoMock.getCantidadPisadasAlFreno());
	}

}
