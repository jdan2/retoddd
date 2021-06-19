package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.bolera.partida.values.PartidaId;
import co.com.sofka.domain.generic.Command;

public class CrearPartida implements Command {
    private final PartidaId partidaId;
    private final Capacidad capacidad;

    public CrearPartida(PartidaId partidaId, Capacidad capacidad) {
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
