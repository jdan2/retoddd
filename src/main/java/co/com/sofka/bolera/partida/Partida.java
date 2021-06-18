package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.generics.Puntos;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.partida.events.*;
import co.com.sofka.bolera.partida.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.*;

public class Partida extends AggregateEvent<PartidaId> {

    protected Capacidad capacidad;
    protected List<Turnos> turno;
    protected Podio podio;
    protected Consumo consumo;
    protected Set<JugadorId> jugadorId;

    public Partida(PartidaId entityId, Capacidad capacidad) {
        super(entityId);
        appendChange(new PartidaCreada(capacidad));
    }

    private Partida(PartidaId entityId){
        super(entityId);
        subscribe(new PartidaChange(this));
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
        appendChange(new LanzamientosDeTurnoActualizado(turnoId, lanzamientos)).apply();
    }

    public void agregarPuntosDeTurno(TurnoId turnoId, Puntos puntos){
        appendChange(new PuntosDeTurnoAgregado(turnoId, puntos)).apply();
    }

    public void actualizarValorDeConsumo(ConsumoId consumoId, Valor valor){
        appendChange(new ValorDeConsumoActualizado(consumoId, valor)).apply();
    }

    public void actualizarValorFinalConsumo(ConsumoId consumoId, ValorFinal valorFinal){
        appendChange(new ValorFinalDeConsumoActualizado(consumoId, valorFinal)).apply();
    }

    public void actualizarDescuentoConsumo(ConsumoId consumoId, ValorFinal valorFinal){
        appendChange(new DescuentoDeConsumoActualizado(consumoId, valorFinal)).apply();
    }

    public void agregarPuntosDePodio(PodioId podioId, JugadorId jugadorId, Puntos puntos){
        appendChange(new PuntosDePodioAgregado(podioId, jugadorId, puntos)).apply();
    }

    public void agregarPuestoDePodio(PodioId podioId, Puesto puesto){
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
