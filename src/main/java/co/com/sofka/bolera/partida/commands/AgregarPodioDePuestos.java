package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.values.PodioId;
import co.com.sofka.bolera.partida.values.Puesto;
import co.com.sofka.domain.generic.Command;

public class AgregarPodioDePuestos implements Command {
    private final PodioId podioId;
    private final Puesto puesto;

    public AgregarPodioDePuestos(PodioId podioId, Puesto puesto) {
        this.podioId = podioId;
        this.puesto = puesto;
    }

    public PodioId getPodioId() {
        return podioId;
    }

    public Puesto getPuesto() {
        return puesto;
    }
}
