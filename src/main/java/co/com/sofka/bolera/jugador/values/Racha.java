package co.com.sofka.bolera.jugador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Racha implements ValueObject<Integer> {

    private final Integer value;

    public Racha(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("La racha no puede estar vacio");
        }

        if (this.value < 0){
            throw new IllegalArgumentException("La racha no puede ser negativo");
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
        Racha racha = (Racha) o;
        return Objects.equals(value, racha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
