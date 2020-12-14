package fiuba.algo3.ejemploMockito;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InOrder;

public class MockitoTest {

    @Test
    public void verificarComportamiento() {

        //creacion de mock de una interface
        List mockedList = mock(List.class);

        //utilizando el mock object
        mockedList.add("one");
        mockedList.clear();

        //verificacion
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void agregarComportamiento() {

        //mock de clase concreta
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));

        verify(mockedList).get(0);
    }

    @Test
    public void lanzarExcepcion() {

        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(1)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            mockedList.get(1);
        });
    }

    @Test
    public void verificarCantidadDeInvocaciones() {

        LinkedList<String> mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //las dos verificaciones siguientes trabajan de la misma manera
        // times(1) se usa por defecto
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //verificacion de numero exacto de invaciones
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verificacion utilizando never. never() es un alias de times(0)
        verify(mockedList, never()).add("never happened");

        //verificacion utilizando atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("once");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }


    @Test
    public void verificarOrdenDeInvocaciones() {

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first");
        secondMock.add("was called second");

        //creamos un objeto inOrder, pasando los mocks que necesitan verificarse en orden
        InOrder inOrder = inOrder(firstMock, secondMock);

        //verficamos que firstMock ha sido invocado antes que secondMock
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }
}

