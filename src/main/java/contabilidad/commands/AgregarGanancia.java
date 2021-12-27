package contabilidad.commands;

import co.com.sofka.domain.generic.Command;
import contabilidad.values.*;

public class AgregarGanancia extends Command {

    private final ContabilidadID contabilidadID;
    private final GananciaID gananciaID;
    private final Valor valor;

    public ContabilidadID contabilidadID() {
        return contabilidadID;
    }

    public GananciaID gananciaID() {
        return gananciaID;
    }

    public Valor valor() {
        return valor;
    }

    public AgregarGanancia(ContabilidadID contabilidadID, GananciaID gananciaID, Valor valor) {
        this.contabilidadID = contabilidadID;
        this.gananciaID = gananciaID;
        this.valor = valor;
    }
}
