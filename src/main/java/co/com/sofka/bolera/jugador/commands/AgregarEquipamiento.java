package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.Descripcion;
import co.com.sofka.bolera.jugador.values.EquipamientoId;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.domain.generic.Command;

public class AgregarEquipamiento implements Command {
    private final EquipamientoId entityId;
    private final Tipo tipo;
    private final Descripcion descripcion;
    private final JugadorId jugadorId;

    public AgregarEquipamiento(EquipamientoId entityId, Tipo tipo, Descripcion descripcion, JugadorId jugadorId) {
        this.entityId = entityId;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.jugadorId = jugadorId;
    }

    public EquipamientoId getEntityId() {
        return entityId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
