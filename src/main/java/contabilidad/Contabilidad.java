package contabilidad;

import co.com.sofka.domain.generic.AggregateEvent;
import contabilidad.entities.*;
import contabilidad.events.*;
import contabilidad.values.*;

import java.util.*;

public class Contabilidad extends AggregateEvent<ContabilidadID> {

    protected Set<Ganancia> ganancias;
    protected Set<Gasto> gastos;
    protected Set<Ingreso> ingresos;

    public Contabilidad(ContabilidadID entityId) {
        super(entityId);
    }

    public Set<Ganancia> ganancias() {
        return ganancias;
    }

    public Set<Gasto> gastos() {
        return gastos;
    }

    public Set<Ingreso> ingresos() {
        return ingresos;
    }

    //Commands:

    public void agregarGanancia(GananciaID gananciaID, Valor valor) {
        Objects.requireNonNull(gananciaID);
        Objects.requireNonNull(valor);

        appendChange(new GananciaAgregada(gananciaID, valor)).apply();
    }

    public void agregarGasto(GastoID gastoID, Concepto concepto, Descripcion descripcion, Valor valor) {
        Objects.requireNonNull(gastoID);
        Objects.requireNonNull(concepto);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(valor);

        appendChange((new GastoAgregado(gastoID, concepto, descripcion, valor))).apply();
    }

    public void agregarIngreso(IngresoID ingresoID, Concepto concepto, Descripcion descripcion, Valor valor) {
        Objects.requireNonNull(ingresoID);
        Objects.requireNonNull(concepto);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(valor);

        appendChange((new IngresoAgregado(ingresoID, concepto, descripcion, valor))).apply();
    }
}
