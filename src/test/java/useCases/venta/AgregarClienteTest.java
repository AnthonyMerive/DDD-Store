package useCases.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import venta.events.*;
import venta.values.*;
import venta.commands.AgregarCliente;
import venta.useCases.AgregarClienteUseCase;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarClienteTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarCliente(){

        //Arrange:

        VentaID ventaID = VentaID.of("xxxx");
        ClienteID clienteID = new ClienteID();
        Nombre nombre = new Nombre("Jose Perez");
        Direccion direccion = new Direccion("cra.13B #161-70");
        MontoPago montoPago = new MontoPago(150000.0);

        var command = new AgregarCliente(clienteID, ventaID, nombre, direccion, montoPago);
        var useCase = new AgregarClienteUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (ClienteAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals("Jose Perez", event.nombre().value());
        Assertions.assertEquals("cra.13B #161-70", event.direccion().value());
        Assertions.assertEquals(150000.0, event.montoPago().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new VentaCreada(
                VentaID.of("xxxx")
        ));
    }
}
