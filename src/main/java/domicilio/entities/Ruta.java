package domicilio.entities;

import co.com.sofka.domain.generic.Entity;
import domicilio.values.*;

import java.util.Objects;

public class Ruta extends Entity<RutaID>{

    private LocalSalida localSalida;
    private DireccionEntrega direccionEntrega;
    private CostoDomicilio costoDomicilio;

    public LocalSalida localSalida() {
        return localSalida;
    }

    public DireccionEntrega direccionEntrega() {
        return direccionEntrega;
    }

    public CostoDomicilio costoDomicilio() {
        return costoDomicilio;
    }

    public Ruta(RutaID entityId, LocalSalida localSalida, DireccionEntrega direccionEntrega, CostoDomicilio costoDomicilio) {
        super(entityId);
        this.localSalida = localSalida;
        this.direccionEntrega = direccionEntrega;
        this.costoDomicilio = costoDomicilio;
    }

    public void actualizarLocalSalida(LocalSalida localSalida){
        this.localSalida = Objects.requireNonNull(localSalida);
    }

    public void actualizarDireccionEntrega(DireccionEntrega direccionEntrega){
        this.direccionEntrega = Objects.requireNonNull(direccionEntrega);
    }

    public void actualizarCostoDomicilio(CostoDomicilio costoDomicilio){
        this.costoDomicilio = Objects.requireNonNull(costoDomicilio);
    }
}
