package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.Descripcion;
import co.com.sofka.bolera.jugador.values.EquipamientoId;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeEquipamientoActualizado extends DomainEvent {
    private final EquipamientoId entityId;
    private final Descripcion descripcion;

    public DescripcionDeEquipamientoActualizado(EquipamientoId entityId, Descripcion descripcion) {
        super("sofka.juego.desdecripciondeequipamientoactualizado");
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
