package contabilidad.commands;

import co.com.sofka.domain.generic.Command;
import contabilidad.values.*;

public class AgregarIngreso extends Command {

    private final IngresoID ingresoID;
    private final ContabilidadID contabilidadID;
    private final Concepto concepto;
    private final Descripcion descripcion;
    private final Valor valor;

    public IngresoID ingresoID() {
        return ingresoID;
    }

    public ContabilidadID contabilidadID() {
        return contabilidadID;
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

    public AgregarIngreso(IngresoID ingresoID, ContabilidadID contabilidadID, Concepto concepto, Descripcion descripcion, Valor valor) {
        this.ingresoID = ingresoID;
        this.contabilidadID = contabilidadID;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }
}
