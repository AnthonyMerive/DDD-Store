package contabilidad.entities;

import co.com.sofka.domain.generic.Entity;
import contabilidad.values.*;

import java.util.Objects;

public class Ingreso extends Entity<IngresoID> {

    private Concepto concepto;
    private Descripcion descripcion;
    private Valor valor;

    public Concepto concepto() {
        return concepto;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Valor valor() {
        return valor;
    }

    public Ingreso(IngresoID entityId, Concepto concepto, Descripcion descripcion, Valor valor) {
        super(entityId);
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public void actualizarConcepto(Concepto concepto){
        this.concepto = Objects.requireNonNull(concepto);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarValor(Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }
}
