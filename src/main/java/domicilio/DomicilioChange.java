package domicilio;

import co.com.sofka.domain.generic.EventChange;
import domicilio.entities.*;
import domicilio.events.*;

public class DomicilioChange extends EventChange {

    public DomicilioChange(Domicilio domicilio) {

        apply((OrdenAgregada event) ->{
            var numDeOrdenes = domicilio.ordenes().size();

            if(numDeOrdenes > 1){
                throw new IllegalArgumentException("Solo debe existir una orden por domicilio");
            }

            domicilio.ordenes.add(new Orden(
                    event.ordenID(),
                    event.descripcion(),
                    event.horaCreacion(),
                    event.horaEntrega()
            ));

        });

        apply((RepartidorAgregado event) ->{
            var numDeRepartidores = domicilio.repartidores().size();

            if(numDeRepartidores > 1){
                throw new IllegalArgumentException("Solo debe existir un repartidor por domicilio");
            }

            domicilio.repartidores.add(new Repartidor(
                    event.repartidorID(),
                    event.nombre(),
                    event.telefono(),
                    event.ubicacion()
            ));

        });

        apply((RutaAgregada event) ->{
            var numDeRutas = domicilio.rutas().size();

            if(numDeRutas > 1){
                throw new IllegalArgumentException("Solo debe existir una ruta por domicilio");
            }

            domicilio.rutas.add(new Ruta(
                    event.rutaID(),
                    event.localSalida(),
                    event.direccionEntrega(),
                    event.costoDomicilio()
            ));

        });

    }

}
