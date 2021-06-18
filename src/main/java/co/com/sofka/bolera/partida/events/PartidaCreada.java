package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.domain.generic.DomainEvent;

public class PartidaCreada extends DomainEvent {
    private final Capacidad capacidad;

    public PartidaCreada(Capacidad capacidad) {
        super("sofka.partida.partidacreada");
        this.capacidad = capacidad;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
