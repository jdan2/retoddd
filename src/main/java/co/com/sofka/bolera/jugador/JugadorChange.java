package co.com.sofka.bolera.jugador;

import co.com.sofka.bolera.jugador.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.List;


public class JugadorChange extends EventChange {

    public JugadorChange(Jugador jugador){

        apply((JugadorCreado event)->{
            jugador.nombre = event.getNombre();
            jugador.email = event.getEmail();
        });

        apply((HistorialCreado event)->{
             jugador.historial = new Historial(
                     event.getHistorial().identity(),
                     event.getHistorial().racha(),
                     event.getHistorial().mayorPuntaje(),
                     event.getHistorial().getJugadorId()
             );
        });

        apply((MembresiaCreada event)->
                jugador.membresia = new Membresia(
                        event.getMembresia().identity(),
                        event.getMembresia().precio(),
                        event.getMembresia().tipo(),
                        event.getMembresia().jugadorId()
                ));

        apply((EquipamientoAgregado event)->{
            jugador.equipamientos =  new Equipamiento(
                    event.getEntityId(),
                    event.getTipo(),
                    event.getDescripcion(),
                    event.getJugadorId()
                    );
        });

        apply((TipoDeEquipamientoActualizado event)->{
            jugador.equipamientos.actualizarTipo(event.getTipo());
        });

        apply((DescripcionDeEquipamientoActualizado event)->{
            jugador.equipamientos.actualizarDescripcion(event.getDescripcion());
        });

        apply((PrecioDeMembresiaActualizado event) ->{
            jugador.membresia.actualizarPrecio(event.getPrecio());
        });

        apply((NombreDeJugadorActualizado event )->{
            jugador.nombre = event.getNombre();
        });

        apply((TipoDeMembresiaActualizado event) ->{
            jugador.membresia.actualizarTipo(event.getTipo());
        });

        apply((RachaDeHistorialActualizada event)->{
            jugador.historial.actualizarRacha(event.getRacha());
        });

        apply((MayorPuntajeDeHistorialActualizado event)->{
            jugador.historial.actualizarMayorPuntaje(event.getMayorPuntaje());
        });
    }
}
