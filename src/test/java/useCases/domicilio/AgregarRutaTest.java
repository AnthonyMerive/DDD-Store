package useCases.domicilio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import domicilio.commands.AgregarRepartidor;
import domicilio.commands.AgregarRuta;
import domicilio.entities.Ruta;
import domicilio.useCases.AgregarRepartidorUseCase;
import domicilio.useCases.AgregarRutaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import domicilio.events.*;
import domicilio.values.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarRutaTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarRuta(){

        //Arrange:

        DomicilioID domicilioID = DomicilioID.of("xxxx");
        RutaID rutaID = new RutaID();
        LocalSalida localSalida = new LocalSalida("Cedritos Cll 145");
        DireccionEntrega direccionEntrega = new DireccionEntrega("cra.13B#161-70");
        CostoDomicilio costoDomicilio = new CostoDomicilio(4500.0);

        var command = new AgregarRuta(rutaID, domicilioID, localSalida, direccionEntrega, costoDomicilio);
        var useCase = new AgregarRutaUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (RutaAgregada) events.getDomainEvents().get(1);
        Assertions.assertEquals("Cedritos Cll 145", event.localSalida().value());
        Assertions.assertEquals("cra.13B#161-70", event.direccionEntrega().value());
        Assertions.assertEquals(4500.0, event.costoDomicilio().value());
        Mockito.verify(repository).getEventsBy("xxxx");

    }

    private List<DomainEvent> eventList() {
        return List.of(new DomicilioCreado(
                DomicilioID.of("xxxx")
        ));
    }
}
