package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.HistorialId;
import co.com.sofka.bolera.jugador.values.Racha;
import co.com.sofka.domain.generic.DomainEvent;

public class RachaDeHistorialActualizada extends DomainEvent {

    private final HistorialId entityId;
    private final Racha racha;

    public RachaDeHistorialActualizada(HistorialId entityId, Racha racha) {
        super("sofka.juego.rachadehistorialactualizada");
        this.entityId = entityId;
        this.racha = racha;
    }

    public HistorialId getEntityId() {
        return entityId;
    }

    public Racha getRacha() {
        return racha;
    }
}
