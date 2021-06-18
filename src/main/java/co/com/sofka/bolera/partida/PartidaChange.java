package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.jugador.events.PrecioDeMembresiaActualizado;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.events.*;
import co.com.sofka.domain.generic.EventChange;

public class PartidaChange extends EventChange {
    public PartidaChange(Partida partida) {

        apply((PartidaCreada event)->{
            partida.capacidad = event.getCapacidad();
        });

        apply((ConsumoCreado event)->{
            partida.consumo  = event.getConsumo();
        });

        apply((TurnosAgregados event )->{
            partida.turno.add(new Turnos(
                    event.getTurnoId(),
                    event.getPuntos(),
                    event.getLanzamientos(),
                    event.getJugadorId()
            ));
        });

        apply((PodioCreado event)->{
            partida.podio = event.getPodio();
        });

        apply((JugadorAgregado event)->{
            partida.agregarJugador((JugadorId) partida.jugadorId);
        });


    }

}
