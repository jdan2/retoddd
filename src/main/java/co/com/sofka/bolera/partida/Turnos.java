package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.Lanzamientos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Turnos extends Entity<TurnoId> {
    private Puntos puntos;
    private Lanzamientos lanzamientos;
    private JugadorId jugadorId;

    public Turnos(TurnoId entityId, Puntos puntos, Lanzamientos lanzamientos, JugadorId jugadorId) {
        super(entityId);
        this.puntos = puntos;
        this.lanzamientos = lanzamientos;
        this.jugadorId = jugadorId;
    }

    public void actualizarLanzamientos(Lanzamientos lanzamientos){
        this.lanzamientos = Objects.requireNonNull(lanzamientos);
    }

    public void actualizarPuntos(Puntos puntos){
        this.puntos = Objects.requireNonNull(puntos);
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
