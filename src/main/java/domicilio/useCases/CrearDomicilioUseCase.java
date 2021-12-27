package domicilio.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domicilio.Domicilio;
import domicilio.commands.CrearDomicilio;

public class CrearDomicilioUseCase extends UseCase<RequestCommand<CrearDomicilio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearDomicilio> requestCommand) {
        var command = requestCommand.getCommand();

        Domicilio domicilio;

        domicilio = new Domicilio(
                command.domicilioID()
        );

        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
