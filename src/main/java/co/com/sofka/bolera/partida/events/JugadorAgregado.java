package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class JugadorAgregado extends DomainEvent {
    private final JugadorId jugadorId;

    public JugadorAgregado(JugadorId jugadorId) {
        super("sofka.partida.jugadoragregado");
        this.jugadorId = jugadorId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
