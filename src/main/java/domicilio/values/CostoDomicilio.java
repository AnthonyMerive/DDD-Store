package domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CostoDomicilio implements ValueObject<Double> {

    private final Double value;

    public CostoDomicilio(Double value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("El valor no puede ser menor a cero");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostoDomicilio that = (CostoDomicilio) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
