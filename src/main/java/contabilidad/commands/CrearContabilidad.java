package contabilidad.commands;

import co.com.sofka.domain.generic.Command;
import contabilidad.values.ContabilidadID;

public class CrearContabilidad extends Command {

    private final ContabilidadID contabilidadID;

    public ContabilidadID contabilidadID() {
        return contabilidadID;
    }

    public CrearContabilidad(ContabilidadID contabilidadID) {
        this.contabilidadID = contabilidadID;
    }
}
