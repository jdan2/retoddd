package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDeJugador implements Command {


    private final JugadorId jugadorId;
    private final Nombre nombre;

    public ActualizarNombreDeJugador(JugadorId jugadorId, Nombre nombre) {

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
