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

import venta.commands.AgregarVendedor;
import venta.events.*;
import venta.useCases.AgregarVendedorUseCase;
import venta.values.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarVendedorTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarVendedor(){

        //Arrange:

        VentaID ventaID = VentaID.of("xxxx");
        VendedorID vendedorID = new VendedorID();
        Nombre nombre = new Nombre("Antonio Lopez");
        Dependencia dependencia = new Dependencia("Belleza");
        MontoRecibido montoRecibido = new MontoRecibido(150000.0);

        var command = new AgregarVendedor(vendedorID, ventaID, nombre, dependencia, montoRecibido);
        var useCase = new AgregarVendedorUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (VendedorAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals("Antonio Lopez", event.nombre().value());
        Assertions.assertEquals("Belleza", event.dependencia().value());
        Assertions.assertEquals(150000.0, event.montoRecibido().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new VentaCreada(
                VentaID.of("xxxx")
        ));
    }
}
