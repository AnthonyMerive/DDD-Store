package contabilidad.values;

import co.com.sofka.domain.generic.Identity;

public class ContabilidadID extends Identity {

    public ContabilidadID(){

    }

    private ContabilidadID(String id){
        super(id);
    }

    public static ContabilidadID of(String id){
        return new ContabilidadID(id);
    }
}
