package domicilio.entities;

import co.com.sofka.domain.generic.Entity;
import domicilio.values.*;

import java.util.Objects;

public class Repartidor extends Entity<RepartidorID> {

    private Nombre nombre;
    private Telefono telefono;
    private Ubicacion ubicacion;

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public Repartidor(RepartidorID entityId, Nombre nombre, Telefono telefono, Ubicacion ubicacion) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

    public void actualizarUbicacion(Ubicacion ubicacion){
        this.ubicacion = Objects.requireNonNull(ubicacion);
    }
}
