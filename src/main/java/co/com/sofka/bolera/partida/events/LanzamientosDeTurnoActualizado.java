package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.Lanzamientos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.DomainEvent;

public class LanzamientosDeTurnoActualizado extends DomainEvent {
    private final TurnoId turnoId;
    private final Lanzamientos lanzamientos;

    public LanzamientosDeTurnoActualizado(TurnoId turnoId, Lanzamientos lanzamientos) {
        super("sofka.partdia.lanzamientosdeturnoactualizado");
        this.turnoId = turnoId;
        this.lanzamientos = lanzamientos;
    }

    public TurnoId getTurnoId() {
        return turnoId;
    }

    public Lanzamientos getLanzamientos() {
        return lanzamientos;
    }
}
