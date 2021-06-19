package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeJugadorActualizado extends DomainEvent {


    private final JugadorId jugadorId;
    private final Nombre nombre;

    public NombreDeJugadorActualizado(JugadorId jugadorId, Nombre nombre) {
        super("sofka.juego.nombredejugadoractualizado");

        this.jugadorId = jugadorId;
        this.nombre = nombre;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
