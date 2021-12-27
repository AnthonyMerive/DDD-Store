package domicilio.events;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.values.DomicilioID;

public class DomicilioCreado extends DomainEvent {

    private final DomicilioID domicilioID;

    public DomicilioID getDomicilioID() {
        return domicilioID;
    }

    public DomicilioCreado(DomicilioID domicilioID) {
        super("ventas.domicilio.domicilio-creado");
        this.domicilioID = domicilioID;
    }
}
