package venta.commands;

import co.com.sofka.domain.generic.Command;
import venta.values.*;

public class AgregarCliente extends Command {

    private final ClienteID clienteID;
    private final VentaID ventaID;
    private final Nombre nombre;
    private final Direccion direccion;
    private final MontoPago montoPago;

    public ClienteID clienteID() {
        return clienteID;
    }

    public VentaID ventaID() {
        return ventaID;
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

    public AgregarCliente(ClienteID clienteID, VentaID ventaID, Nombre nombre, Direccion direccion, MontoPago montoPago) {
        this.clienteID = clienteID;
        this.ventaID = ventaID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.montoPago = montoPago;
    }
}
