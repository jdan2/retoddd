package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descuento implements ValueObject<Integer> {

    private final Integer value;

    public Descuento(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("El Descuento no puede estar vacio");
        }

        if (this.value < 0){
            throw new IllegalArgumentException("El descuento no puede ser negativo");
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
        Descuento descuento = (Descuento) o;
        return Objects.equals(value, descuento.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
