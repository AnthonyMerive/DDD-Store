package venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.values.DomicilioID;

public class DomicilioAsociado extends DomainEvent {

    private final DomicilioID domicilioID;

    public DomicilioID domicilioID() {
        return domicilioID;
    }

    public DomicilioAsociado(DomicilioID domicilioID) {

        super("ventas.venta.domicilio-asociado");

        this.domicilioID = domicilioID;
    }
}
