package useCases.contabilidad;

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

import contabilidad.events.*;
import contabilidad.values.*;
import contabilidad.commands.AgregarGanancia;
import contabilidad.useCases.AgregarGananciaUseCase;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarGananciaTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarGanancia(){

        //Arrange:

        ContabilidadID contabilidadID = ContabilidadID.of("xxxx");
        GananciaID gananciaID = new GananciaID();
        Valor valor = new Valor(20000.0);

        var command = new AgregarGanancia(contabilidadID, gananciaID, valor);
        var useCase = new AgregarGananciaUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (GananciaAgregada) events.getDomainEvents().get(1);
        Assertions.assertEquals(20000.0, event.valor().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new ContabilidadCreada(
                ContabilidadID.of("xxxx")
        ));
    }

}
