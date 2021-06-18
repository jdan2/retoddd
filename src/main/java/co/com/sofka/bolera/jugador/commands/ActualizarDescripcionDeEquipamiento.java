package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.Descripcion;
import co.com.sofka.bolera.jugador.values.EquipamientoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionDeEquipamiento implements Command {
    private final EquipamientoId entityId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeEquipamiento(EquipamientoId entityId, Descripcion descripcion) {
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public EquipamientoId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
