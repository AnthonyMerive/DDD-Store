package contabilidad.entities;

import co.com.sofka.domain.generic.Entity;
import contabilidad.values.*;

import java.util.*;

public class Gasto extends Entity<GastoID> {

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

    public Gasto(GastoID entityId, Concepto concepto, Descripcion descripcion, Valor valor) {
        super(entityId);
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public void actualizarconcepto(Concepto concepto){
        this.concepto = Objects.requireNonNull(concepto);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarValor(Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }
}
