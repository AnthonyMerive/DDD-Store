package contabilidad.values;

import co.com.sofka.domain.generic.Identity;

public class GananciaID extends Identity {

    public GananciaID(){

    }

    private GananciaID(String id){
        super(id);
    }

    public static GananciaID of(String id){
        return new GananciaID(id);
    }
}
