package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Integer> {

    private Integer value;

    public Valor(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("El Valor no puede estar vacio");
        }

        if (this.value < 0){
            throw new IllegalArgumentException("El Valor no puede ser negativo");
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
        Valor valor = (Valor) o;
        return Objects.equals(value, valor.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
