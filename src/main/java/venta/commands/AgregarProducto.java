package venta.commands;

import co.com.sofka.domain.generic.Command;
import venta.values.*;

public class AgregarProducto extends Command {

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

    public AgregarProducto(ProductoID productoID, Nombre nombre, Descripcion descripcion, CostoProducto costoProducto) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoProducto = costoProducto;
    }
}
