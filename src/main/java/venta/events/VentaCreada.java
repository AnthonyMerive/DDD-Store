package venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import venta.values.VentaID;

public class VentaCreada extends DomainEvent {

    private final VentaID ventaID;

    public VentaID ventaID() {
        return ventaID;
    }

    public VentaCreada(VentaID ventaID) {
        super("ventas.venta.venta-creada");
        this.ventaID = ventaID;
    }
}
