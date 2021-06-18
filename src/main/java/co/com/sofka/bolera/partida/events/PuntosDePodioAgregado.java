package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.PodioId;
import co.com.sofka.domain.generic.DomainEvent;

public class PuntosDePodioAgregado extends DomainEvent {
    private PodioId podioId;
    private JugadorId jugadorId;
    private Puntos puntos;

    public PuntosDePodioAgregado(PodioId podioId, JugadorId jugadorId, Puntos puntos) {
        super("sofka.partida.puntosdepodioagregado");
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
