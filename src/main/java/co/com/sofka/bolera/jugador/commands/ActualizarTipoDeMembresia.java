package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoDeMembresia implements Command {
    private final MembresiaId entityId;
    private final Tipo tipo;

    public ActualizarTipoDeMembresia(MembresiaId entityId, Tipo tipo) {
        this.entityId = entityId;
        this.tipo = tipo;
    }

    public MembresiaId getEntityId() {
        return entityId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
