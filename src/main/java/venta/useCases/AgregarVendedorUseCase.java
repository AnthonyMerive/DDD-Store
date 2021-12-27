package venta.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import venta.Venta;
import venta.commands.AgregarVendedor;

public class AgregarVendedorUseCase extends UseCase<RequestCommand<AgregarVendedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarVendedor> requestCommand) {
        var command = requestCommand.getCommand();

        Venta venta;

        venta = Venta.from(command.ventaID(), retrieveEvents());

        venta.agregarVendedor(
                command.vendedorID(),
                command.nombre(),
                command.dependencia(),
                command.montoRecibido()
        );

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
