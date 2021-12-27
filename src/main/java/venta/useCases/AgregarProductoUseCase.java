package venta.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import venta.Venta;
import venta.commands.AgregarProducto;

public class AgregarProductoUseCase extends UseCase<RequestCommand<AgregarProducto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarProducto> requestCommand) {
        var command = requestCommand.getCommand();

        Venta venta;

        venta = Venta.from(command.ventaID(), retrieveEvents());

        venta.agregarProducto(
                command.productoID(),
                command.nombre(),
                command.descripcion(),
                command.costoProducto()
        );

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
