package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;

public class CrearJugador implements Command {

    private final JugadorId entityId;
    private final Nombre nombre;
    private final Email email;

    public CrearJugador(JugadorId entityId, Nombre nombre, Email email) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.email = email;
    }

    public JugadorId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
