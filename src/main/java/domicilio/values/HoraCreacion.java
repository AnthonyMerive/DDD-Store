package domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalTime;

public class HoraCreacion implements ValueObject<LocalTime> {

    public LocalTime value() {
        return LocalTime.now();
    }
}
