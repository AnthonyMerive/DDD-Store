package venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import venta.values.*;

public class VendedorAgregado extends DomainEvent{

    private final VendedorID vendedorID;
    private final Nombre nombre;
    private final Dependencia dependencia;
    private final MontoRecibido montoRecibido;

    public VendedorID vendedorID() {
        return vendedorID;
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

    public VendedorAgregado(VendedorID vendedorID, Nombre nombre, Dependencia dependencia, MontoRecibido montoRecibido) {

        super("ventas.venta.vendedor-agregado");

        this.vendedorID = vendedorID;
        this.nombre = nombre;
        this.dependencia = dependencia;
        this.montoRecibido = montoRecibido;
    }

}
