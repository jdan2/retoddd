package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailDeJugadorActualizado extends DomainEvent {

    private JugadorId jugadorId;
    private Email email;

    public EmailDeJugadorActualizado(JugadorId jugadorId, Email email) {
        super("sofka.jugador.emaildejugadoractualizado");
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
