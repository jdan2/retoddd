package co.com.sofka.bolera.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Membresia extends Entity<MembresiaId> {

    private Precio precio;
    private Tipo tipo;
    private JugadorId jugadorId;

    public Membresia(MembresiaId entityId, Precio precio, Tipo tipo, JugadorId jugadorId) {
        super(entityId);
        this.precio = precio;
        this.tipo = tipo;
        this.jugadorId = jugadorId;
    }


    public void actualizarPrecio(Precio precio){
        this.precio = Objects.requireNonNull(precio);
    }

    public void actualizarTipo(Tipo tipo){
        this.tipo = Objects.requireNonNull(tipo);
    }

    public Precio precio() {
        return precio;
    }

    public Tipo tipo() {
        return tipo;
    }

    public JugadorId jugadorId() {
        return jugadorId;
    }
}
