package useCases.domicilio;

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

import domicilio.events.*;
import domicilio.values.*;
import domicilio.commands.AgregarOrden;
import domicilio.useCases.AgregarOrdenUseCase;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarOrdenTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarOrden(){

        //Arrange:

        DomicilioID domicilioID = DomicilioID.of("xxxx");
        OrdenID ordenID = new OrdenID();
        HoraCreacion horaCreacion = new HoraCreacion();
        HoraEntrega horaEntrega = new HoraEntrega();
        Descripcion descripcion = new Descripcion("soy una descripcion");

        var command = new AgregarOrden(ordenID, domicilioID, horaCreacion, horaEntrega, descripcion);
        var useCase = new AgregarOrdenUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (OrdenAgregada) events.getDomainEvents().get(1);
        Assertions.assertEquals("soy una descripcion", event.descripcion().value());
        Assertions.assertEquals(horaCreacion, event.horaCreacion());
        Assertions.assertEquals(horaEntrega, event.horaEntrega());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new DomicilioCreado(
                DomicilioID.of("xxxx")
        ));
    }
}
