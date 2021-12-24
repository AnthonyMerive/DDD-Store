package domicilio.events;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.values.*;

public class OrdenAgregada extends DomainEvent {

    private final OrdenID ordenID;
    private final HoraCreacion horaCreacion;
    private final HoraEntrega horaEntrega;
    private final Descripcion descripcion;

    public OrdenID ordenID() {
        return ordenID;
    }

    public HoraCreacion horaCreacion() {
        return horaCreacion;
    }

    public HoraEntrega horaEntrega() {
        return horaEntrega;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public OrdenAgregada(OrdenID ordenID, HoraCreacion horaCreacion, HoraEntrega horaEntrega, Descripcion descripcion) {

        super("ventas.domicilio.orden-agregada");

        this.ordenID = ordenID;
        this.horaCreacion = horaCreacion;
        this.horaEntrega = horaEntrega;
        this.descripcion = descripcion;
    }
}
