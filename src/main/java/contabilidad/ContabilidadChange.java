package contabilidad;

import co.com.sofka.domain.generic.EventChange;
import contabilidad.entities.*;
import contabilidad.events.*;

import java.util.HashSet;

public class ContabilidadChange extends EventChange {

    public ContabilidadChange(Contabilidad contabilidad) {

        apply((ContabilidadCreada event) ->{
            contabilidad.ingresos = new HashSet<>();
            contabilidad.ganancias = new HashSet<>();
            contabilidad.gastos = new HashSet<>();
        });

        apply((GananciaAgregada event) ->{

            contabilidad.ganancias.add(new Ganancia(
                    event.gananciaID(),
                    event.valor()
            ));

        });

        apply((GastoAgregado event) ->{

            contabilidad.gastos.add(new Gasto(
                    event.gastoID(),
                    event.concepto(),
                    event.descripcion(),
                    event.valor()
            ));

        });

        apply((IngresoAgregado event) ->{

            contabilidad.ingresos.add(new Ingreso(
                    event.ingresoID(),
                    event.concepto(),
                    event.descripcion(),
                    event.valor()
            ));
        });
    }

}
