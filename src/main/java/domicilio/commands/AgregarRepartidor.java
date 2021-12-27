package domicilio.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.*;

public class AgregarRepartidor extends Command {

    private final RepartidorID repartidorID;
    private final DomicilioID domicilioID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Ubicacion ubicacion;

    public RepartidorID repartidorID() {
        return repartidorID;
    }

    public DomicilioID domicilioID() {
        return domicilioID;
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

    public AgregarRepartidor(RepartidorID repartidorID, DomicilioID domicilioID, Nombre nombre, Telefono telefono, Ubicacion ubicacion) {
        this.repartidorID = repartidorID;
        this.domicilioID = domicilioID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }
}
