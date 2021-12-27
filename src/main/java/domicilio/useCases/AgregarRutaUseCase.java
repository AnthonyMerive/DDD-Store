package domicilio.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domicilio.Domicilio;
import domicilio.commands.AgregarRuta;

public class AgregarRutaUseCase extends UseCase<RequestCommand<AgregarRuta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarRuta> requestCommand) {
        var command = requestCommand.getCommand();

        Domicilio domicilio;

        domicilio = Domicilio.from(command.domicilioID(), retrieveEvents());

        domicilio.agregarRuta(
                command.rutaID(),
                command.localSalida(),
                command.direccionEntrega(),
                command.costoDomicilio()
        );

        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
