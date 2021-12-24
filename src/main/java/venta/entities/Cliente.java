package venta.entities;

import co.com.sofka.domain.generic.Entity;
import venta.values.*;

import java.util.*;

public class Cliente extends Entity<ClienteID>{

    private Nombre nombre;
    private Direccion direccion;
    private MontoPago montoPago;

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

    public MontoPago montoPago() {
        return montoPago;
    }

    public Cliente(ClienteID entityId, Nombre nombre, Direccion direccion, MontoPago montoPago) {
        super(entityId);
        this.nombre = nombre;
        this.direccion = direccion;
        this.montoPago = montoPago;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarDireccion(Direccion direccion){
        this.direccion = Objects.requireNonNull(direccion);
    }

    public void actualizarMontoPago(MontoPago montoPago){
        this.montoPago = Objects.requireNonNull(montoPago);
    }
}
