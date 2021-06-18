package co.com.sofka.bolera.jugador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MayorPuntaje implements ValueObject<Integer> {

    private final Integer value;

    public MayorPuntaje(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("Valor no puede estar vacio");
        }

    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MayorPuntaje that = (MayorPuntaje) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
