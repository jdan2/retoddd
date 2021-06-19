package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.Lanzamientos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.Command;

public class AgregarTurno implements Command {
    private final Puntos puntos;
    private final Lanzamientos lanzamientos;
    private final JugadorId jugadorId;

    public AgregarTurno(TurnoId turnoId, Puntos puntos, Lanzamientos lanzamientos, JugadorId jugadorId) {
        this.puntos = puntos;
        this.lanzamientos = lanzamientos;
        this.jugadorId = jugadorId;
    }

    public Puntos getPuntos() {
        return puntos;
    }

    public Lanzamientos getLanzamientos() {
        return lanzamientos;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
