package domicilio.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.*;
public class AgregarOrden extends Command {

    private final OrdenID ordenID;
    private final DomicilioID domicilioID;
    private final HoraCreacion horaCreacion;
    private final HoraEntrega horaEntrega;
    private final Descripcion descripcion;

    public OrdenID ordenID() {
        return ordenID;
    }

    public DomicilioID domicilioID() {
        return domicilioID;
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

    public AgregarOrden(OrdenID ordenID, DomicilioID domicilioID, HoraCreacion horaCreacion, HoraEntrega horaEntrega, Descripcion descripcion) {
        this.ordenID = ordenID;
        this.domicilioID = domicilioID;
        this.horaCreacion = horaCreacion;
        this.horaEntrega = horaEntrega;
        this.descripcion = descripcion;
    }
}
