package co.com.sofka.bolera.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.Descripcion;
import co.com.sofka.bolera.jugador.values.EquipamientoId;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;


public class Equipamiento extends Entity<EquipamientoId> {


    private Tipo tipo;
    private Descripcion descripcion;
    private JugadorId jugadorId;

    public Equipamiento(EquipamientoId entityId, Tipo tipo, Descripcion descripcion, JugadorId jugadorId) {
        super(entityId);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.jugadorId = jugadorId;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion  = Objects.requireNonNull(descripcion);
    }

    public void actualizarTipo(Tipo tipo){
        this.tipo  = Objects.requireNonNull(tipo);
    }

    public Tipo tipo() {
        return tipo;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public JugadorId jugadorId() {
        return jugadorId;
    }
}
