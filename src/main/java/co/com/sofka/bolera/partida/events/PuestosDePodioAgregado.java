package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.PodioId;
import co.com.sofka.bolera.partida.values.Puesto;
import co.com.sofka.domain.generic.DomainEvent;

public class PuestosDePodioAgregado extends DomainEvent {
    private PodioId podioId;
    private Puesto puesto;

    public PuestosDePodioAgregado(PodioId podioId, Puesto puesto) {
        super("sofka.partida.puestosdepodioagregado");
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
