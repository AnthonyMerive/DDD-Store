package contabilidad.commands;

import co.com.sofka.domain.generic.Command;
import contabilidad.values.*;

public class AgregarGanancia extends Command {

    private final GananciaID gananciaID;
    private final Valor valor;

    public GananciaID gananciaID() {
        return gananciaID;
    }

    public Valor valor() {
        return valor;
    }

    public AgregarGanancia(GananciaID gananciaID, Valor valor) {
        this.gananciaID = gananciaID;
        this.valor = valor;
    }
}
