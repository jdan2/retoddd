package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.Membresia;
import co.com.sofka.domain.generic.Command;

public class CrearMembresia implements Command {
    private final Membresia membresia;

    public CrearMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public Membresia getMembresia() {
        return membresia;
    }
}
