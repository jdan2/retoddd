package co.com.sofka.bolera.jugador;

import co.com.sofka.bolera.jugador.values.HistorialId;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MayorPuntaje;
import co.com.sofka.bolera.jugador.values.Racha;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;
import java.util.Optional;

public class Historial extends Entity<HistorialId> {

    private Racha racha;
    private MayorPuntaje mayorPuntaje;
    private JugadorId jugadorId;

    public Historial(HistorialId entityId, Racha racha, MayorPuntaje mayorPuntaje , JugadorId jugadorId) {
        super(entityId);
        this.racha = racha;
        this.mayorPuntaje = mayorPuntaje;
        this.jugadorId = jugadorId;
    }

    public void actualizarRacha(Racha racha){
        this.racha = Objects.requireNonNull(racha);
    }

    public void actualizarMayorPuntaje(MayorPuntaje mayorPuntaje){
        this.racha = Objects.requireNonNull(racha);
    }

    public Racha racha() {
        return racha;
    }

    public MayorPuntaje mayorPuntaje() {
        return mayorPuntaje;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

}
