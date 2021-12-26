package contabilidad.commands;

import co.com.sofka.domain.generic.Command;
import contabilidad.values.*;

public class AgregarGasto extends Command {

    private final GastoID gastoID;
    private final Concepto concepto;
    private final Descripcion descripcion;
    private final Valor valor;

    public GastoID gastoID() {
        return gastoID;
    }

    public Concepto voncepto() {
        return concepto;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Valor valor() {
        return valor;
    }

    public AgregarGasto(GastoID gastoID, Concepto concepto, Descripcion descripcion, Valor valor) {
        this.gastoID = gastoID;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.valor = valor;
    }
}
