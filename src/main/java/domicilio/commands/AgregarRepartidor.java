package domicilio.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.*;

public class AgregarRepartidor extends Command {

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

    public AgregarRepartidor(RepartidorID repartidorID, Nombre nombre, Telefono telefono, Ubicacion ubicacion) {
        this.repartidorID = repartidorID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }
}
