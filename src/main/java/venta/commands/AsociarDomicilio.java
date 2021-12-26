package venta.commands;

import co.com.sofka.domain.generic.Command;
import domicilio.values.DomicilioID;

public class AsociarDomicilio extends Command {

    private final DomicilioID domicilioID;

    public DomicilioID domicilioID() {
        return domicilioID;
    }

    public AsociarDomicilio(DomicilioID domicilioID) {
        this.domicilioID = domicilioID;
    }
}
