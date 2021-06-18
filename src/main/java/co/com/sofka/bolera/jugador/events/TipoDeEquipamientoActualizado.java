package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.EquipamientoId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeEquipamientoActualizado extends DomainEvent {
    private final EquipamientoId entityId;
    private final Tipo tipo;

    public TipoDeEquipamientoActualizado(EquipamientoId entityId, Tipo tipo) {
        super("sofka.juego.tipodeequipamientoactualizado");
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
