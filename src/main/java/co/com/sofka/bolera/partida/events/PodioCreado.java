package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.Podio;
import co.com.sofka.domain.generic.DomainEvent;

public class PodioCreado extends DomainEvent {
    private final Podio podio;

    public PodioCreado(Podio podio) {
        super("sofka.partida.podiocreado");
        this.podio = podio;
    }

    public Podio getPodio() {
        return podio;
    }
}
