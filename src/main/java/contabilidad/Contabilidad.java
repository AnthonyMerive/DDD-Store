package contabilidad;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
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
        appendChange(new ContabilidadCreada(entityId)).apply();
        subscribe(new ContabilidadChange(this));
    }

    //Factory:

    public static Contabilidad from(ContabilidadID contabilidadID, List<DomainEvent> events){
        var contabilidad = new Contabilidad(contabilidadID);
        events.forEach(contabilidad::applyEvent);
        return contabilidad;
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

    protected Optional<Ganancia> obtenerGananciaPorID(GananciaID gananciaID){
        return ganancias()
                .stream()
                .filter(ganancia -> ganancia.identity().equals(gananciaID)).findFirst();
    }

    protected Optional<Gasto> obtenerGastoPorID(GastoID gastoID){
        return gastos()
                .stream()
                .filter(gasto -> gasto.identity().equals(gastoID)).findFirst();
    }

    protected Optional<Ingreso> obtenerIngresoPorID(IngresoID ingresoID){
        return ingresos()
                .stream()
                .filter(ingreso -> ingreso.identity().equals(ingresoID)).findFirst();
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
