package domicilio.values;

import co.com.sofka.domain.generic.Identity;

public class RutaID extends Identity {

    public RutaID(){

    }

    private RutaID(String id){
        super(id);
    }

    public static RutaID of(String id){
        return new RutaID(id);
    }
}
