package contabilidad.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import contabilidad.Contabilidad;
import contabilidad.commands.AgregarIngreso;

public class AgregarIngresoUseCase extends UseCase<RequestCommand<AgregarIngreso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarIngreso> requestCommand) {
        var command = requestCommand.getCommand();

        Contabilidad contabilidad;

        contabilidad = Contabilidad.from(command.contabilidadID(), retrieveEvents());

        contabilidad.agregarIngreso(
                command.ingresoID(),
                command.concepto(),
                command.descripcion(),
                command.valor()
        );

        emit().onResponse(new ResponseEvents(contabilidad.getUncommittedChanges()));
    }
}
