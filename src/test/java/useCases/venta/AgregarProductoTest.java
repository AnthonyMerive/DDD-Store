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

import venta.commands.AgregarProducto;
import venta.events.*;
import venta.useCases.AgregarProductoUseCase;
import venta.values.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarProductoTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarProducto(){

        //Arrange:

        VentaID ventaID = VentaID.of("xxxx");
        ProductoID productoID = new ProductoID();
        Nombre nombre = new Nombre("Plancha para Cabello babyliss");
        Descripcion descripcion = new Descripcion("Plancha de ceramica");
        CostoProducto costoProducto = new CostoProducto(130000.0);

        var command = new AgregarProducto(productoID, ventaID, nombre, descripcion, costoProducto);
        var useCase = new AgregarProductoUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (ProductoAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals("Plancha para Cabello babyliss", event.nombre().value());
        Assertions.assertEquals("Plancha de ceramica", event.descripcion().value());
        Assertions.assertEquals(130000.0, event.costoProducto().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new VentaCreada(
                VentaID.of("xxxx")
        ));
    }

}
