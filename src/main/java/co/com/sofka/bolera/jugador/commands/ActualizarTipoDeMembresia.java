package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoDeMembresia implements Command {
    private final MembresiaId entityId;
    private final Tipo tipo;
    private final JugadorId jugadorId;

    public ActualizarTipoDeMembresia(MembresiaId entityId, Tipo tipo, JugadorId jugadorId) {
        this.entityId = entityId;
        this.tipo = tipo;
        this.jugadorId = jugadorId;
    }

    public MembresiaId getEntityId() {
        return entityId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
