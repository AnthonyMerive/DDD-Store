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

import contabilidad.values.*;
import contabilidad.events.*;
import contabilidad.commands.AgregarGasto;
import contabilidad.useCases.AgregarGastoUseCase;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarGastoTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarGasto(){

        //Arrange:

        ContabilidadID contabilidadID = ContabilidadID.of("xxxx");
        GastoID gastoID = new GastoID();
        Valor valor = new Valor(20000.0);
        Concepto concepto = new Concepto("soy un concepto");
        Descripcion descripcion = new Descripcion("soy una descripcion");

        var command = new AgregarGasto(gastoID, contabilidadID, concepto, descripcion, valor);
        var useCase = new AgregarGastoUseCase();

        //Act:

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts:

        var event = (GastoAgregado) events.getDomainEvents().get(1);
        Assertions.assertEquals(20000.0, event.valor().value());
        Assertions.assertEquals("soy un concepto", event.concepto().value());
        Assertions.assertEquals("soy una descripcion", event.descripcion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new ContabilidadCreada(
                ContabilidadID.of("xxxx")
        ));
    }

}

