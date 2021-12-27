package contabilidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import contabilidad.values.ContabilidadID;

public class ContabilidadCreada extends DomainEvent {

    private final ContabilidadID contabilidadID;

    public ContabilidadID contabilidadID() {
        return contabilidadID;
    }

    public ContabilidadCreada(ContabilidadID contabilidadID) {
        super("ventas.contabilidad.contabilidad-creada");
        this.contabilidadID = contabilidadID;
    }
}
