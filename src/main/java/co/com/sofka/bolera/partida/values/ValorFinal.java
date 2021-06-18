package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorFinal implements ValueObject<Integer> {

    private Integer value;

    public ValorFinal(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(null)){
            throw new IllegalArgumentException("El Valor Final no puede estar vacio");
        }

        if (this.value < 0){
            throw new IllegalArgumentException("El Valor Final no puede ser negativo");
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
        ValorFinal that = (ValorFinal) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
