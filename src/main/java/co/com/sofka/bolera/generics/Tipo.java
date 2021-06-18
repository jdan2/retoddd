package co.com.sofka.bolera.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {
    private String value;

    public Tipo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El Tipo no puede estar vacio");
        }

        if (this.value.length() <= 5){
            throw new IllegalArgumentException("El Tipo debe ser mayor a 5 caracteres");
        }

        if (this.value.length() >= 30){
            throw new IllegalArgumentException("El Tipo debe ser menor a 30 caracteres");
        }

    }

    @Override
    public String value() {
        return value;
    }
}
