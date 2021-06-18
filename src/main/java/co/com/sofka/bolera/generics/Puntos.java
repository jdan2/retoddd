package co.com.sofka.bolera.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Puntos implements ValueObject<Integer> {

    private final Integer value;

    public Puntos(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntos puntos = (Puntos) o;
        return Objects.equals(value, puntos.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
