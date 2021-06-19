package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.domain.generic.Command;

public class AgregarJugador implements Command {
    private final JugadorId jugadorId;

    public AgregarJugador(JugadorId jugadorId) {
        this.jugadorId = jugadorId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
