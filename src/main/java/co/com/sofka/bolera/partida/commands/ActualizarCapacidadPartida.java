package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.bolera.partida.values.PartidaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarCapacidadPartida implements Command {
    private final PartidaId partidaId;
    private final Capacidad capacidad;

    public ActualizarCapacidadPartida(PartidaId partidaId, Capacidad capacidad) {
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
