package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.domain.generic.Command;

public class ActualizarPrecioDeMembresia implements Command {
    private final MembresiaId entityId;
    private final Precio precio;
    private final JugadorId jugadorId;

    public ActualizarPrecioDeMembresia(MembresiaId entityId, Precio precio, JugadorId jugadorId) {
        this.entityId = entityId;
        this.precio = precio;
        this.jugadorId = jugadorId;
    }

    public MembresiaId getEntityId() {
        return entityId;
    }

    public Precio getPrecio() {
        return precio;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
