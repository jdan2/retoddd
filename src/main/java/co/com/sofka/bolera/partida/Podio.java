package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.PodioId;
import co.com.sofka.domain.generic.Entity;

import java.util.Map;

public class Podio extends Entity<PodioId> {

    private Map<JugadorId, Puntos> puntosJugador;

    public Podio(PodioId entityId, Map<JugadorId, Puntos> puntosJugador) {
        super(entityId);
        this.puntosJugador = puntosJugador;
    }

    public Map<JugadorId, Puntos> getPuntosJugador() {
        return puntosJugador;
    }
}
