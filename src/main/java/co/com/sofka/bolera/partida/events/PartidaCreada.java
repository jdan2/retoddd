package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.bolera.partida.values.PartidaId;
import co.com.sofka.domain.generic.DomainEvent;

public class PartidaCreada extends DomainEvent {
    private final PartidaId partidaId;
    private final Capacidad capacidad;

    public PartidaCreada(PartidaId partidaId, Capacidad capacidad) {
        super("sofka.partida.partidacreada");
        this.partidaId = partidaId;
        this.capacidad = capacidad;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public PartidaId getPartidaId() {
        return partidaId;
    }
}
