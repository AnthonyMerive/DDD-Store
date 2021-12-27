package contabilidad.commands;

import co.com.sofka.domain.generic.Command;
import contabilidad.values.*;

public class AgregarGasto extends Command {

    private final GastoID gastoID;
    private final ContabilidadID contabilidadID;
    private final Concepto concepto;
    private final Descripcion descripcion;
    private final Valor valor;

    public GastoID gastoID() {
        return gastoID;
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

    public AgregarGasto(GastoID gastoID, ContabilidadID contabilidadID, Concepto concepto, Descripcion descripcion, Valor valor) {
        this.gastoID = gastoID;
        this.contabilidadID = contabilidadID;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }
}
