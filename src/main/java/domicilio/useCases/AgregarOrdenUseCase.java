package domicilio.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domicilio.Domicilio;
import domicilio.commands.AgregarOrden;

public class AgregarOrdenUseCase extends UseCase<RequestCommand<AgregarOrden>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarOrden> requestCommand) {
        var command = requestCommand.getCommand();

        Domicilio domicilio;

        domicilio = Domicilio.from(command.domicilioID(), retrieveEvents());

        domicilio.agregarOrden(
                command.ordenID(),
                command.horaCreacion(),
                command.horaEntrega(),
                command.descripcion()
        );

        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
