package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.Podio;
import co.com.sofka.domain.generic.Command;

public class CrearPodio implements Command {
    private final Podio podio;

    public CrearPodio(Podio podio) {
        this.podio = podio;
    }

    public Podio getPodio() {
        return podio;
    }
}
