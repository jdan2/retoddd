package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.values.Lanzamientos;
import co.com.sofka.bolera.partida.values.TurnoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTurnoDeLanzamiento implements Command {
    private final TurnoId turnoId;
    private final Lanzamientos lanzamientos;

    public ActualizarTurnoDeLanzamiento(TurnoId turnoId, Lanzamientos lanzamientos) {
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
