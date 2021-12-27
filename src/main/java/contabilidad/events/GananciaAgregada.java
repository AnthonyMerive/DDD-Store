package contabilidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import contabilidad.values.*;

public class GananciaAgregada extends DomainEvent {

    private final GananciaID gananciaID;

    private final Valor valor;

    public GananciaID gananciaID() {
        return gananciaID;
    }

    public Valor valor() {
        return valor;
    }

    public GananciaAgregada(GananciaID entityID, Valor valor) {

        super("ventas.contabilidad.ganancia-agregada");

        gananciaID = entityID;

        this.valor = valor;
    }

}
