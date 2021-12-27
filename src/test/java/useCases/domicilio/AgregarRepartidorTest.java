package useCases.domicilio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import domicilio.commands.AgregarRepartidor;
import domicilio.useCases.AgregarRepartidorUseCase;
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
class AgregarRepartidorTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarRepartidor(){

        //Arrange:

        DomicilioID domicilioID = DomicilioID.of("xxxx");
        RepartidorID repartidorID = new RepartidorID();
        Nombre nombre = new Nombre("Anthony Colmenares");
        Telefono telefono = new Telefono("3202312631");
        Ubicacion ubicacion = new Ubicacion("cra.13B#161-70");

        var command = new AgregarRepartidor(repartidorID, domicilioID, nombre, telefono, ubicacion);
        var useCase = new AgregarRepartidorUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (RepartidorAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals("Anthony Colmenares", event.nombre().value());
        Assertions.assertEquals("3202312631", event.telefono().value());
        Assertions.assertEquals("cra.13B#161-70", event.ubicacion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new DomicilioCreado(
                DomicilioID.of("xxxx")
        ));
    }
}
