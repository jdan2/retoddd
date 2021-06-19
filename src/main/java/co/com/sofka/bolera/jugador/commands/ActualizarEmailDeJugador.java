package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarEmailDeJugador implements Command {


    private final JugadorId jugadorId;
    private final Email email;

    public ActualizarEmailDeJugador(JugadorId jugadorId, Email email) {
        this.jugadorId = jugadorId;
        this.email = email;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Email getEmail() {
        return email;
    }
}
