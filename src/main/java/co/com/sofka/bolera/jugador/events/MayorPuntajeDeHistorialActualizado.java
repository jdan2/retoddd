package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.HistorialId;
import co.com.sofka.bolera.jugador.values.MayorPuntaje;
import co.com.sofka.domain.generic.DomainEvent;

public class MayorPuntajeDeHistorialActualizado extends DomainEvent {
    private final HistorialId entityId;
    private final MayorPuntaje mayorPuntaje;

    public MayorPuntajeDeHistorialActualizado(HistorialId entityId, MayorPuntaje mayorPuntaje) {
        super("sofka.juego.mayorpuntajedehistorialactualizado");
        this.entityId = entityId;
        this.mayorPuntaje = mayorPuntaje;
    }

    public HistorialId getEntityId() {
        return entityId;
    }

    public MayorPuntaje getMayorPuntaje() {
        return mayorPuntaje;
    }
}
