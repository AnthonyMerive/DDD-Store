package domicilio.entities;

import co.com.sofka.domain.generic.Entity;
import domicilio.values.*;

import java.util.*;

public class Orden extends Entity<OrdenID> {

    private Descripcion descripcion;
    private HoraCreacion horaCreacion;
    private HoraEntrega horaEntrega;

    public Descripcion descripcion() {
        return descripcion;
    }

    public HoraCreacion horaCreacion() {
        return horaCreacion;
    }

    public HoraEntrega horaEntrega() {
        return horaEntrega;
    }

    public Orden(OrdenID entityId, Descripcion descripcion, HoraCreacion horaCreacion, HoraEntrega horaEntrega) {
        super(entityId);
        this.descripcion = descripcion;
        this.horaCreacion = horaCreacion;
        this.horaEntrega = horaEntrega;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarHoraCreacion(HoraCreacion horaCreacion){
        this.horaCreacion = Objects.requireNonNull(horaCreacion);
    }

    public void actualizarHoraEntrega(HoraEntrega horaEntrega){
        this.horaEntrega = Objects.requireNonNull(horaEntrega);
    }
}
