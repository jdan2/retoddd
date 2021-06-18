package co.com.sofka.bolera.jugador;

import co.com.sofka.bolera.jugador.events.*;
import co.com.sofka.domain.generic.EventChange;



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
            jugador.equipamientos.add( new Equipamiento(
                    event.getEntityId(),
                    event.getTipo(),
                    event.getDescripcion(),
                    event.getJugadorId()
                    ));
        });

        apply((TipoDeEquipamientoActualizado event)->{
            var equipamiento = jugador.getEquipamientoPorId(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el equipamiento"));
            equipamiento.actualizarTipo(event.getTipo());
        });

        apply((DescripcionDeEquipamientoActualizado event)->{
            var equipamiento = jugador.getEquipamientoPorId(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el equipamiento"));
            equipamiento.actualizarDescripcion(event.getDescripcion());
        });

        apply((PrecioDeMembresiaActualizado event) ->{
            jugador.membresia.actualizarPrecio(event.getPrecio());
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
