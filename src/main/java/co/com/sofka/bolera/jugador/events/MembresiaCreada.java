package co.com.sofka.bolera.jugador.events;

import co.com.sofka.bolera.jugador.Membresia;
import co.com.sofka.domain.generic.DomainEvent;

public class MembresiaCreada extends DomainEvent {
    private final Membresia membresia;

    public MembresiaCreada(Membresia membresia) {
        super("sofka.jugador.membresiacreada");
        this.membresia = membresia;
    }

    public Membresia getMembresia() {
        return membresia;
    }
}
