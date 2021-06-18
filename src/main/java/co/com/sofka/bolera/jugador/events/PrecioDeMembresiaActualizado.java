package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class PrecioDeMembresiaActualizado extends DomainEvent {
    private final MembresiaId entityId;
    private final Precio precio;

    public PrecioDeMembresiaActualizado(MembresiaId entityId, Precio precio) {
        super("sofka.juego.preciodemembresiaactualizado");
        this.entityId = entityId;
        this.precio = precio;
    }

    public MembresiaId getEntityId() {
        return entityId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
