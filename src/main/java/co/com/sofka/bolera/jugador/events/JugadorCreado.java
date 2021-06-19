package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class JugadorCreado extends DomainEvent {
    private final JugadorId entityId;
    private final Nombre nombre;
    private final Email email;

    public JugadorCreado(JugadorId entityId, Nombre nombre, Email email) {
        super("sofka.jugador.jugadorcreado");
        this.entityId = entityId;
        this.nombre = nombre;
        this.email = email;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }

    public JugadorId getEntityId() {
        return entityId;
    }
}
