package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import model.Conductor;
import model.IVehiculo;

public class ConductorTest {

	@Test
	public void elConductorLaBardeo() {
		
		IVehiculo vehiculoMock = mock(IVehiculo.class);
		
		when(vehiculoMock.tocarBocina()).thenReturn(true);
		when(vehiculoMock.frenar()).thenReturn(true);
		
		Conductor conductor = new Conductor(vehiculoMock);
		
		boolean ofendido = true;
		
		Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));
		
		verify(vehiculoMock,times(1)).tocarBocina();
		verify(vehiculoMock,times(1)).frenar();
	}
	
	
	@Test
	public void elConductorEstaTranquilo() {

		IVehiculo vehiculoMock = mock(IVehiculo.class);
		
		when(vehiculoMock.tocarBocina()).thenReturn(true);
		when(vehiculoMock.frenar()).thenReturn(true);
		
		Conductor conductor = new Conductor(vehiculoMock);
		
		boolean ofendido = false;
		
		Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));
		
		verify(vehiculoMock,never()).tocarBocina();
		verify(vehiculoMock,times(1)).frenar();
	}

}
