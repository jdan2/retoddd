package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PuntosDeTurnoAgregado extends DomainEvent {
    private TurnoId turnoId;
    private Puntos puntos;

    public PuntosDeTurnoAgregado(TurnoId turnoId, Puntos puntos) {
        super("sofka.partida.puntosdeturnoagregado");
        this.turnoId = turnoId;
        this.puntos = puntos;
    }

    public TurnoId getTurnoId() {
        return turnoId;
    }

    public Puntos getPuntos() {
        return puntos;
    }
}
