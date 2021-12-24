package venta.entities;

import co.com.sofka.domain.generic.Entity;
import venta.values.*;

import java.util.*;

public class Vendedor extends Entity<VendedorID>{

    private Nombre nombre;
    private Dependencia dependencia;
    private MontoRecibido montoRecibido;

    public Nombre nombre() {
        return nombre;
    }

    public Dependencia dependencia() {
        return dependencia;
    }

    public MontoRecibido montoRecibido() {
        return montoRecibido;
    }

    public Vendedor(VendedorID entityId, Nombre nombre, Dependencia dependencia, MontoRecibido montoRecibido) {
        super(entityId);
        this.nombre = nombre;
        this.dependencia = dependencia;
        this.montoRecibido = montoRecibido;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarDependencia(Dependencia dependencia){
        this.dependencia = Objects.requireNonNull(dependencia);
    }

    public void actualizarMontoRecibido(MontoRecibido montoRecibido){
        this.montoRecibido = Objects.requireNonNull(montoRecibido);
    }
}
