package domicilio.values;

import co.com.sofka.domain.generic.Identity;

public class OrdenID extends Identity {

    public OrdenID(){

    }

    private OrdenID(String id){
        super(id);
    }

    public static OrdenID of(String id){
        return new OrdenID(id);
    }
}
