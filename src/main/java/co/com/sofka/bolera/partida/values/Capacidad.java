package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacidad implements ValueObject<Integer> {

    private final Integer value;

    public Capacidad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("La Capacidad no puede estar vacio");
        }

        if (this.value < 0){
            throw new IllegalArgumentException("La Capacidad no puede ser negativo");
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
        Capacidad capacidad = (Capacidad) o;
        return Objects.equals(value, capacidad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
