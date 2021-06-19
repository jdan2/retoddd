package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.PodioId;
import co.com.sofka.domain.generic.Command;

public class AgregarPuntoDePodio implements Command {
    private final PodioId podioId;
    private final JugadorId jugadorId;
    private final Puntos puntos;

    public AgregarPuntoDePodio(PodioId podioId, JugadorId jugadorId, Puntos puntos) {
        this.podioId = podioId;
        this.jugadorId = jugadorId;
        this.puntos = puntos;
    }

    public PodioId getPodioId() {
        return podioId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Puntos getPuntos() {
        return puntos;
    }
}
