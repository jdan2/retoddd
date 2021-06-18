package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeMembresiaActualizado extends DomainEvent {
    private final MembresiaId entityId;
    private final Tipo tipo;

    public TipoDeMembresiaActualizado(MembresiaId entityId, Tipo tipo) {
        super("sofka.jugador.tipodemembresiaactualizado");
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
