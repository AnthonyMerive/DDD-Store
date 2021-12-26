package venta.commands;

import co.com.sofka.domain.generic.Command;
import venta.values.*;

public class AgregarCliente extends Command {

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

    public AgregarCliente(ClienteID clienteID, Nombre nombre, Direccion direccion, MontoPago montoPago) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.montoPago = montoPago;
    }
}
