package venta.commands;

import co.com.sofka.domain.generic.Command;
import venta.values.VentaID;

public class CrearVenta extends Command {

    private final VentaID ventaID;

    public VentaID ventaID() {
        return ventaID;
    }

    public CrearVenta(VentaID ventaID) {
        this.ventaID = ventaID;
    }
}
