package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.EquipamientoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoDeEquipamiento implements Command {
    private final EquipamientoId entityId;
    private final Tipo tipo;

    public ActualizarTipoDeEquipamiento(EquipamientoId entityId, Tipo tipo) {
        this.entityId = entityId;
        this.tipo = tipo;
    }

    public EquipamientoId getEntityId() {
        return entityId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
