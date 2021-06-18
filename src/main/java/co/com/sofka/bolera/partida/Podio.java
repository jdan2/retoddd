package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.values.PodioId;
import co.com.sofka.bolera.partida.values.Puesto;
import co.com.sofka.domain.generic.Entity;

import java.util.Map;
import java.util.Objects;

public class Podio extends Entity<PodioId> {

    private Map<JugadorId, Puntos> puntosJugador;
    private Puesto puesto;

    public Podio(PodioId entityId, Map<JugadorId, Puntos> puntosJugador, Puesto puesto) {
        super(entityId);
        this.puntosJugador = Objects.requireNonNull(puntosJugador);
        this.puesto = puesto;
    }

     public void  agregarPuntos( Map<JugadorId, Puntos> puntosJugador){
        this.puntosJugador = Objects.requireNonNull(puntosJugador);
     }

     public void actualizarPuesto(Puesto puesto){
        this.puesto = Objects.requireNonNull(puesto);
     }

    public Map<JugadorId, Puntos> getPuntosJugador() {
        return puntosJugador;
    }

    public Puesto getPuesto() {
        return puesto;
    }
}
