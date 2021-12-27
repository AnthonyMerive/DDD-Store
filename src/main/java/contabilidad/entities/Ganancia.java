package contabilidad.entities;

import co.com.sofka.domain.generic.Entity;
import contabilidad.values.*;

import java.util.*;

public class Ganancia extends Entity<GananciaID> {

    private Valor valor;

    public Valor valor() {
        return valor;
    }

    public Ganancia(GananciaID entityId, Valor valor) {
        super(entityId);
        this.valor = Objects.requireNonNull(valor);
    }

    public void actualizarValor(Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }
}
