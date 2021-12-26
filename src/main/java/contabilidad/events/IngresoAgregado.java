package contabilidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import contabilidad.values.*;

public class IngresoAgregado extends DomainEvent {

    private final IngresoID ingresoID;
    private final Concepto concepto;
    private final Descripcion descripcion;
    private final Valor valor;

    public IngresoID ingresoID() {
        return ingresoID;
    }

    public Concepto concepto() {
        return concepto;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Valor valor() {
        return valor;
    }

    public IngresoAgregado(IngresoID ingresoID, Concepto concepto, Descripcion descripcion, Valor valor) {

        super("ventas.contabilidad.ingreso-agregado");

        this.ingresoID = ingresoID;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }
}
