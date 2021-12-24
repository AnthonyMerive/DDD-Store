package domicilio.events;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.values.*;

public class RepartidorAgregado extends DomainEvent {

    private final RepartidorID repartidorID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Ubicacion ubicacion;

    public RepartidorID repartidorID() {
        return repartidorID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public RepartidorAgregado(RepartidorID repartidorID, Nombre nombre, Telefono telefono, Ubicacion ubicacion) {

        super("ventas.domicilio.repartidor-agregado");

        this.repartidorID = repartidorID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }
}
