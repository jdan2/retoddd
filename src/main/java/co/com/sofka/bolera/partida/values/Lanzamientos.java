package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Lanzamientos implements ValueObject<Integer> {

    private final Integer value;

    public Lanzamientos(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("El Lanzamiento no puede estar vacio");
        }

        if (this.value < 0){
            throw new IllegalArgumentException("El lanzamiento no puede ser negativo");
        }

    }

    @Override
    public Integer value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lanzamientos that = (Lanzamientos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
