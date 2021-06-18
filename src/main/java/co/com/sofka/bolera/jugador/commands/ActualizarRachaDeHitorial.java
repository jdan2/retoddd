package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.HistorialId;
import co.com.sofka.bolera.jugador.values.Racha;
import co.com.sofka.domain.generic.Command;

public class ActualizarRachaDeHitorial implements Command {
    private final HistorialId entityId;
    private final Racha racha;

    public ActualizarRachaDeHitorial(HistorialId entityId, Racha racha) {
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
