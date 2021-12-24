package venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import venta.values.*;

public class ClienteAgregado extends DomainEvent {

    private final ClienteID clienteID;
    private final Nombre nombre;
    private final Direccion direccion;
    private final MontoPago montoPago;

    public ClienteID clienteID() {
        return clienteID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

    public MontoPago montoPago() {
        return montoPago;
    }

    public ClienteAgregado(ClienteID clienteID, Nombre nombre, Direccion direccion, MontoPago montoPago) {

        super("ventas.venta.cliente-agregado");

        this.clienteID = clienteID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.montoPago = montoPago;
    }


}
