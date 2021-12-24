package venta.entities;

import co.com.sofka.domain.generic.Entity;
import venta.values.*;

import java.util.*;

public class Producto extends Entity<ProductoID>{

    private Nombre nombre;
    private Descripcion descripcion;
    private CostoProducto costoProducto;

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public CostoProducto costoProducto() {
        return costoProducto;
    }

    public Producto(ProductoID entityId, Nombre nombre, Descripcion descripcion, CostoProducto costoProducto) {
        super(entityId);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoProducto = costoProducto;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarCostoProducto(CostoProducto costoProducto){
        this.costoProducto = Objects.requireNonNull(costoProducto);
    }

}
