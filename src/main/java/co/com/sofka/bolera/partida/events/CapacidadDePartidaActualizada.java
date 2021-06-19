package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.bolera.partida.values.PartidaId;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadDePartidaActualizada extends DomainEvent {
    private final PartidaId partidaId;
    private final Capacidad capacidad;

    public CapacidadDePartidaActualizada(PartidaId partidaId, Capacidad capacidad) {
        super("sofka.partida.capacidaddepartidaactualizada");
        this.partidaId = partidaId;
        this.capacidad = capacidad;
    }

    public PartidaId getPartidaId() {
        return partidaId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
