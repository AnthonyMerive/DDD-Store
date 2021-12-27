package domicilio.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.*;
public class AgregarRuta extends Command {

    private final RutaID rutaID;
    private final DomicilioID domicilioID;
    private final LocalSalida localSalida;
    private final DireccionEntrega direccionEntrega;
    private final CostoDomicilio costoDomicilio;

    public RutaID rutaID() {
        return rutaID;
    }

    public DomicilioID domicilioID() {
        return domicilioID;
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

    public AgregarRuta(RutaID rutaID, DomicilioID domicilioID, LocalSalida localSalida, DireccionEntrega direccionEntrega, CostoDomicilio costoDomicilio) {
        this.rutaID = rutaID;
        this.domicilioID = domicilioID;
        this.localSalida = localSalida;
        this.direccionEntrega = direccionEntrega;
        this.costoDomicilio = costoDomicilio;
    }
}
