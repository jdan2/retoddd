package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.HistorialId;
import co.com.sofka.bolera.jugador.values.MayorPuntaje;
import co.com.sofka.domain.generic.Command;

public class ActualizarMayorPuntajeDeHitorial implements Command {
    private final HistorialId entityId;
    private final MayorPuntaje mayorPuntaje;

    public ActualizarMayorPuntajeDeHitorial(HistorialId entityId, MayorPuntaje mayorPuntaje) {
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
