package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.Historial;
import co.com.sofka.domain.generic.DomainEvent;

public class HistorialCreado extends DomainEvent {

    private final Historial historial;

    public HistorialCreado(Historial historial) {
        super("sofka.jugador.historialcreado");
        this.historial = historial;
    }

    public Historial getHistorial() {
        return historial;
    }
}
