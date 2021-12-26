package domicilio;

import co.com.sofka.domain.generic.AggregateEvent;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.entities.*;
import domicilio.values.*;
import domicilio.events.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Domicilio extends AggregateEvent<DomicilioID> {

    protected Set<Repartidor> repartidores;
    protected Set<Ruta> rutas;
    protected Set<Orden> ordenes;

    public Domicilio(DomicilioID entityId) {
        super(entityId);
        subscribe(new DomicilioChange(this));

    }

    //Factory:

    public static Domicilio from(DomicilioID domicilioID, List<DomainEvent> events){
        var domicilio = new Domicilio(domicilioID);
        events.forEach(domicilio::applyEvent);
        return domicilio;
    }

    public Set<Repartidor> repartidores() {
        return repartidores;
    }

    public Set<Ruta> rutas() {
        return rutas;
    }

    public Set<Orden> ordenes() {
        return ordenes;
    }

    protected Optional<Repartidor> obtenerRepartidorPorID(RepartidorID repartidorID){
        return repartidores
                .stream()
                .filter(repartidor -> repartidor.identity().equals(repartidorID)).findFirst();
    }

    protected Optional<Ruta> obtenerRutaPorID(RutaID rutaID){
        return rutas()
                .stream()
                .filter(ruta -> ruta.identity().equals(rutaID)).findFirst();
    }

    protected Optional<Orden> obtenerOrdenPorID(OrdenID ordenID){
        return ordenes()
                .stream()
                .filter(orden -> orden.identity().equals(ordenID)).findFirst();
    }

    //Commands:

    public void agregarOrden(OrdenID ordenID, HoraCreacion horaCreacion, HoraEntrega horaEntrega, Descripcion descripcion) {
        Objects.requireNonNull(ordenID);
        Objects.requireNonNull(horaCreacion);
        Objects.requireNonNull(horaEntrega);
        Objects.requireNonNull(descripcion);

        appendChange((new OrdenAgregada(ordenID, horaCreacion, horaEntrega, descripcion))).apply();
    }

    public void agregarRepartidor(RepartidorID repartidorID, Nombre nombre, Telefono telefono, Ubicacion ubicacion) {
        Objects.requireNonNull(repartidorID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(ubicacion);

        appendChange((new RepartidorAgregado(repartidorID, nombre, telefono, ubicacion))).apply();
    }

    public void agregarRuta(RutaID rutaID, LocalSalida localSalida, DireccionEntrega direccionEntrega, CostoDomicilio costoDomicilio) {
        Objects.requireNonNull(rutaID);
        Objects.requireNonNull(localSalida);
        Objects.requireNonNull(direccionEntrega);
        Objects.requireNonNull(costoDomicilio);

        appendChange((new RutaAgregada(rutaID, localSalida, direccionEntrega, costoDomicilio))).apply();
    }
}
