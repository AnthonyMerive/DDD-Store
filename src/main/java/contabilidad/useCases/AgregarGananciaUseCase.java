package contabilidad.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import contabilidad.Contabilidad;
import contabilidad.commands.AgregarGanancia;

public class AgregarGananciaUseCase extends UseCase<RequestCommand<AgregarGanancia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarGanancia> requestCommand) {
        var command = requestCommand.getCommand();

        Contabilidad contabilidad;

        contabilidad = Contabilidad.from(command.contabilidadID(), retrieveEvents());

        contabilidad.agregarGanancia(
                command.gananciaID(),
                command.valor()
        );

        emit().onResponse(new ResponseEvents(contabilidad.getUncommittedChanges()));
    }
}
