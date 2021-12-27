package venta.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import venta.Venta;
import venta.commands.CrearVenta;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearVenta> requestCommand) {
        var command = requestCommand.getCommand();

        Venta venta;

        venta = new Venta(
                command.ventaID()
        );

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
