package co.com.sofka.bolera.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.commands.ActualizarNombreDeJugador;
import co.com.sofka.bolera.jugador.events.*;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Jugador extends AggregateEvent<JugadorId> {

    protected Nombre nombre;
    protected Email email;
    protected Historial historial;
    protected Equipamiento equipamientos;
    protected Membresia membresia;

    public Jugador(JugadorId entityId, Nombre nombre, Email email) {
        super(entityId);
        appendChange(new JugadorCreado(entityId, nombre, email)).apply();
    }

    private Jugador(JugadorId entityId){
        super(entityId);
        subscribe(new JugadorChange(this));
    }

    public static Jugador from(JugadorId jugadorId, List<DomainEvent> events){
        var jugador = new Jugador(jugadorId);
        events.forEach(jugador::applyEvent);
        return jugador;
    }

    public void agregarEquipamiento(EquipamientoId entityId, Tipo tipo, Descripcion descripcion, JugadorId jugadorId){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(descripcion);
        appendChange(new EquipamientoAgregado(entityId,tipo,descripcion,jugadorId));
    }

    public void crearHistorial(Historial historial){
        Objects.requireNonNull(historial);
        appendChange(new HistorialCreado(historial)).apply();
    }

    public void crearMembresia(Membresia membresia){
        Objects.requireNonNull(membresia);
        appendChange(new MembresiaCreada(membresia)).apply();
    }

    public void actualizarTipoDeEquipamiento(EquipamientoId entityId, Tipo tipo){
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(entityId);
        appendChange(new TipoDeEquipamientoActualizado(entityId, tipo)).apply();
    }

    public void actualizarNombreDeJugador(JugadorId jugadorId, Nombre nombre){
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(jugadorId);
        appendChange(new NombreDeJugadorActualizado(jugadorId, nombre)).apply();
    }

    public void actualizarEmailDeJugador(JugadorId jugadorId, Email email){
        Objects.requireNonNull(email);
        Objects.requireNonNull(jugadorId);
        appendChange(new EmailDeJugadorActualizado(jugadorId, email)).apply();
    }

    public void actualizarDescripcionDeEquipamiento(EquipamientoId entityId, Descripcion descripcion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionDeEquipamientoActualizado(entityId, descripcion)).apply();
    }

    public void actualizarRachaDeHitorial(HistorialId entityId, Racha racha){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(racha);
        appendChange(new RachaDeHistorialActualizada(entityId, racha)).apply();
    }

    public void actualizarMayorPuntajeDeHitorial(HistorialId entityId, MayorPuntaje mayorPuntaje){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(mayorPuntaje);
        appendChange(new MayorPuntajeDeHistorialActualizado(entityId, mayorPuntaje)).apply();
    }

    public void actualizarTipoDeMembresia(MembresiaId entityId, Tipo tipo){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(tipo);
        appendChange(new TipoDeMembresiaActualizado(entityId, tipo)).apply();
    }

    public void actualizarPrecioDeMembresia(MembresiaId entityId, Precio precio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(precio);
        appendChange(new PrecioDeMembresiaActualizado(entityId, precio)).apply();
    }





    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }

    public Historial historial() {
        return historial;
    }

    public Equipamiento equipamientos() {
        return equipamientos;
    }

    public Membresia membresia() {
        return membresia;
    }
}
