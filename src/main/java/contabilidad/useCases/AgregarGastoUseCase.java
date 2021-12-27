package contabilidad.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import contabilidad.Contabilidad;
import contabilidad.commands.AgregarGasto;

public class AgregarGastoUseCase extends UseCase<RequestCommand<AgregarGasto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarGasto> requestCommand) {
        var command = requestCommand.getCommand();

        Contabilidad contabilidad;

        contabilidad = Contabilidad.from(command.contabilidadID(), retrieveEvents());

        contabilidad.agregarGasto(
                command.gastoID(),
                command.concepto(),
                command.descripcion(),
                command.valor()
        );

        emit().onResponse(new ResponseEvents(contabilidad.getUncommittedChanges()));
    }
}
