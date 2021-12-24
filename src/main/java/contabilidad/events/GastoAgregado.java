package contabilidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import contabilidad.values.*;

public class GastoAgregado extends DomainEvent {

    private final GastoID gastoID;
    private final Concepto concepto;
    private final Descripcion descripcion;
    private final Valor valor;

    public GastoID gastoID() {
        return gastoID;
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

    public GastoAgregado(GastoID gastoID, Concepto concepto, Descripcion descripcion, Valor valor) {

        super("ventas.contabilidad.gasto-agregado");

        this.gastoID = gastoID;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }
}
