package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.Command;

public class AgregarPuntosDeTurno implements Command {
    private final TurnoId turnoId;
    private final Puntos puntos;

    public AgregarPuntosDeTurno(TurnoId turnoId, Puntos puntos) {
        this.turnoId = turnoId;
        this.puntos = puntos;
    }

    public TurnoId getTurnoId() {
        return turnoId;
    }

    public Puntos getPuntos() {
        return puntos;
    }
}
