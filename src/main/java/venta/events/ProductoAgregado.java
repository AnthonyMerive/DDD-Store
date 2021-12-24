package venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import venta.values.*;

public class ProductoAgregado extends DomainEvent {

    private final ProductoID productoID;
    private final Nombre nombre;
    private final Descripcion descripcion;
    private final CostoProducto costoProducto;

    public ProductoID productoID() {
        return productoID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public CostoProducto costoProducto() {
        return costoProducto;
    }

    public ProductoAgregado(ProductoID productoID, Nombre nombre, Descripcion descripcion, CostoProducto costoProducto) {

        super("ventas.veta.producto-agregado");

        this.productoID = productoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoProducto = costoProducto;
    }
}
