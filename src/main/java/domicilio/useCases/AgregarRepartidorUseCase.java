package domicilio.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domicilio.Domicilio;
import domicilio.commands.AgregarRepartidor;

public class AgregarRepartidorUseCase extends UseCase<RequestCommand<AgregarRepartidor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarRepartidor> requestCommand) {
        var command = requestCommand.getCommand();

        Domicilio domicilio;

        domicilio = Domicilio.from(command.domicilioID(), retrieveEvents());

        domicilio.agregarRepartidor(
                command.repartidorID(),
                command.nombre(),
                command.telefono(),
                command.ubicacion()
        );

        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
