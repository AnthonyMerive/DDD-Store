package contabilidad.values;

import co.com.sofka.domain.generic.Identity;

public class GastoID extends Identity {

    public GastoID(){

    }

    private GastoID(String id){
        super(id);
    }

    public static GastoID of(String id){
        return new GastoID(id);
    }
}
