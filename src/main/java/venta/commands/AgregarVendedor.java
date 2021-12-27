package venta.commands;

import co.com.sofka.domain.generic.Command;
import venta.values.*;

public class AgregarVendedor extends Command {

    private final VendedorID vendedorID;
    private final VentaID ventaID;
    private final Nombre nombre;
    private final Dependencia dependencia;
    private final MontoRecibido montoRecibido;

    public VendedorID vendedorID() {
        return vendedorID;
    }

    public VentaID ventaID() {
        return ventaID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Dependencia dependencia() {
        return dependencia;
    }

    public MontoRecibido montoRecibido() {
        return montoRecibido;
    }

    public AgregarVendedor(VendedorID vendedorID, VentaID ventaID, Nombre nombre, Dependencia dependencia, MontoRecibido montoRecibido) {
        this.vendedorID = vendedorID;
        this.ventaID = ventaID;
        this.nombre = nombre;
        this.dependencia = dependencia;
        this.montoRecibido = montoRecibido;
    }
}
