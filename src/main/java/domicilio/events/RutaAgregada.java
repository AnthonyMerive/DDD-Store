package domicilio.events;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.values.*;

public class RutaAgregada extends DomainEvent {

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

    public RutaAgregada(RutaID rutaID, LocalSalida localSalida, DireccionEntrega direccionEntrega, CostoDomicilio costoDomicilio) {

        super("ventas.domicilio.ruta-agregada");

        this.rutaID = rutaID;
        this.localSalida = localSalida;
        this.direccionEntrega = direccionEntrega;
        this.costoDomicilio = costoDomicilio;
    }


}
