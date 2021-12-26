package domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DireccionEntrega implements ValueObject<String> {

    private final String value;

    public DireccionEntrega(String value) {

        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("No puede estar vacio");
        }

        if(this.value.length() <= 4){
            throw new IllegalArgumentException("Minimo de caracteres es 5");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DireccionEntrega that = (DireccionEntrega) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
