package contabilidad.values;

import co.com.sofka.domain.generic.Identity;

public class IngresoID extends Identity {

    public IngresoID(){

    }

    private IngresoID(String id){
        super(id);
    }

    public static IngresoID of(String id){
        return new IngresoID(id);
    }
}
