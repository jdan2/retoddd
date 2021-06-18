package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.Historial;
import co.com.sofka.domain.generic.Command;

public class CrearHistorial implements Command {
    private final Historial historial;

    public CrearHistorial(Historial historial) {
        this.historial = historial;
    }

    public Historial getHistorial() {
        return historial;
    }
}
