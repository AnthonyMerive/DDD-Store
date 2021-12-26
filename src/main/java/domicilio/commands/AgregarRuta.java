package domicilio.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.*;
public class AgregarRuta extends Command {

    private final RutaID rutaID;
    private final LocalSalida localSalida;
    private final DireccionEntrega direccionEntrega;
    private final CostoDomicilio costoDomicilio;

    public RutaID rutaID() {
        return rutaID;
    }

    public LocalSalida localSalida() {
        return localSalida;
    }

    public DireccionEntrega direccionEntrega() {
        return direccionEntrega;
    }

    public CostoDomicilio costoDomicilio() {
        return costoDomicilio;
    }

    public AgregarRuta(RutaID rutaID, LocalSalida localSalida, DireccionEntrega direccionEntrega, CostoDomicilio costoDomicilio) {
        this.rutaID = rutaID;
        this.localSalida = localSalida;
        this.direccionEntrega = direccionEntrega;
        this.costoDomicilio = costoDomicilio;
    }
}
