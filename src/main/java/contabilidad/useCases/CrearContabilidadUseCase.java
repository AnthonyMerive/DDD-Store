package contabilidad.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import contabilidad.Contabilidad;
import contabilidad.commands.CrearContabilidad;

public class CrearContabilidadUseCase extends UseCase<RequestCommand<CrearContabilidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearContabilidad> requestCommand) {
        var command = requestCommand.getCommand();

        Contabilidad contabilidad;

        contabilidad = new Contabilidad(
                command.contabilidadID()
        );

        emit().onResponse(new ResponseEvents(contabilidad.getUncommittedChanges()));
    }
}
