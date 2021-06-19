package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.commands.ActualizarCapacidadPartida;
import co.com.sofka.bolera.partida.events.*;
import co.com.sofka.bolera.partida.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.*;

public class Partida extends AggregateEvent<PartidaId> {

    protected Capacidad capacidad;
    protected List<Turnos> turno;
    protected Podio podio;
    protected Consumo consumo;
    protected Set<JugadorId> jugadorId;

    public Partida(PartidaId entityId, Capacidad capacidad) {
        super(entityId);
        appendChange(new PartidaCreada(entityId,capacidad));
    }

    private Partida(PartidaId entityId){
        super(entityId);
        subscribe(new PartidaChange(this));
    }

    public static Partida from(PartidaId partidaId, List<DomainEvent> events){
        var partida = new Partida(partidaId);
        events.forEach(partida::applyEvent);
        return partida;
    }


    public void crearConsumo(Consumo consumo){
        appendChange(new ConsumoCreado(consumo)).apply();
    }

    public void agregarTurnos(TurnoId turnoId, JugadorId jugadorId, Puntos puntos, Lanzamientos lanzamientos){
        Objects.requireNonNull(turnoId);
        Objects.requireNonNull(jugadorId);
        Objects.requireNonNull(puntos);
        Objects.requireNonNull(lanzamientos);
        appendChange(new TurnosAgregados(turnoId, puntos, lanzamientos, jugadorId )).apply();
    }

    public void crearPodio(Podio podio){
        appendChange(new PodioCreado(podio));
    }

    public void agregarJugador(JugadorId jugadorId){
        appendChange(new JugadorAgregado(jugadorId));
    }

    public void agregarLanzamientosDeTurno(TurnoId turnoId, Lanzamientos lanzamientos){
        Objects.requireNonNull(turnoId);
        Objects.requireNonNull(lanzamientos);
        appendChange(new LanzamientosDeTurnoActualizado(turnoId, lanzamientos)).apply();
    }

    public void agregarPuntosDeTurno(TurnoId turnoId, Puntos puntos){
        Objects.requireNonNull(turnoId);
        Objects.requireNonNull(puntos);
        appendChange(new PuntosDeTurnoAgregado(turnoId, puntos)).apply();
    }

    public void actualizarValorDeConsumo(ConsumoId consumoId, Valor valor){
        Objects.requireNonNull(consumoId);
        Objects.requireNonNull(valor);
        appendChange(new ValorDeConsumoActualizado(consumoId, valor)).apply();
    }

    public void actualizarValorFinalConsumo(ConsumoId consumoId, ValorFinal valorFinal){
        Objects.requireNonNull(consumoId);
        Objects.requireNonNull(valorFinal);
        appendChange(new ValorFinalDeConsumoActualizado(consumoId, valorFinal)).apply();
    }

    public void actualizarCapacidadDePartida(PartidaId entityId, Capacidad capacidad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(capacidad);
        appendChange(new CapacidadDePartidaActualizada(entityId,capacidad)).apply();
    }

    public void actualizarDescuentoConsumo(ConsumoId consumoId, ValorFinal valorFinal){
        Objects.requireNonNull(consumoId);
        Objects.requireNonNull(valorFinal);
        appendChange(new DescuentoDeConsumoActualizado(consumoId, valorFinal)).apply();
    }

    public void agregarPuntosDePodio(PodioId podioId, JugadorId jugadorId, Puntos puntos){
        Objects.requireNonNull(podioId);
        Objects.requireNonNull(jugadorId);
        Objects.requireNonNull(puntos);
        appendChange(new PuntosDePodioAgregado(podioId, jugadorId, puntos)).apply();
    }

    public void agregarPuestoDePodio(PodioId podioId, Puesto puesto){
        Objects.requireNonNull(podioId);
        Objects.requireNonNull(puesto);
        appendChange(new PuestosDePodioAgregado(podioId, puesto)).apply();
    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public List<Turnos> turno() {
        return turno;
    }

    public Podio podio() {
        return podio;
    }

    public Consumo consumo() {
        return consumo;
    }

    public Set<JugadorId> jugadorId() {
        return jugadorId;
    }
}
