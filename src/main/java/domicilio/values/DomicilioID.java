package domicilio.values;

import co.com.sofka.domain.generic.Identity;
import venta.values.VentaID;

public class DomicilioID extends Identity {

    public DomicilioID(){

    }

    private DomicilioID(String id){
        super(id);
    }

    public static DomicilioID of(String id){
        return new DomicilioID(id);
    }
}
