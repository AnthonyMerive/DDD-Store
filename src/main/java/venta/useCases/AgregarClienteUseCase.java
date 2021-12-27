package venta.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import venta.Venta;
import venta.commands.AgregarCliente;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> requestCommand) {
        var command = requestCommand.getCommand();

        Venta venta;

        venta = Venta.from(command.ventaID(), retrieveEvents());

        venta.agregarCliente(
                command.clienteID(),
                command.nombre(),
                command.direccion(),
                command.montoPago()
        );

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
