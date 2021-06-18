package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.Lanzamientos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.DomainEvent;

public class TurnosAgregados extends DomainEvent {
    private final TurnoId turnoId;
    private final Puntos puntos;
    private final Lanzamientos lanzamientos;
    private final JugadorId jugadorId;

    public TurnosAgregados(TurnoId turnoId, Puntos puntos, Lanzamientos lanzamientos, JugadorId jugadorId) {
        super("sofka.partida.turnosagregados");
        this.turnoId = turnoId;
        this.puntos = puntos;
        this.lanzamientos = lanzamientos;
        this.jugadorId = jugadorId;
    }

    public TurnoId getTurnoId() {
        return turnoId;
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
