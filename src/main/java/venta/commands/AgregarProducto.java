package venta.commands;

import co.com.sofka.domain.generic.Command;
import venta.values.*;

public class AgregarProducto extends Command {

    private final ProductoID productoID;
    private final VentaID ventaID;
    private final Nombre nombre;
    private final Descripcion descripcion;
    private final CostoProducto costoProducto;

    public ProductoID productoID() {
        return productoID;
    }

    public VentaID ventaID() {
        return ventaID;
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

    public AgregarProducto(ProductoID productoID, VentaID ventaID, Nombre nombre, Descripcion descripcion, CostoProducto costoProducto) {
        this.productoID = productoID;
        this.ventaID = ventaID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoProducto = costoProducto;
    }
}
