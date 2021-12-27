package domicilio.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.DomicilioID;

public class CrearDomicilio extends Command {

    private final DomicilioID domicilioID;

    public DomicilioID domicilioID() {
        return domicilioID;
    }

    public CrearDomicilio(DomicilioID domicilioID) {
        this.domicilioID = domicilioID;
    }
}
