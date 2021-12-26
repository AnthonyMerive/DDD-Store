package domicilio.values;

import co.com.sofka.domain.generic.Identity;

public class RepartidorID extends Identity {

    public RepartidorID(){

    }

    private RepartidorID(String id){
        super(id);
    }

    public static RepartidorID of(String id){
        return new RepartidorID(id);
    }
}
