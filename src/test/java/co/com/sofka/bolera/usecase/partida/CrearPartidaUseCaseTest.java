package co.com.sofka.bolera.usecase.partida;

import co.com.sofka.bolera.jugador.commands.CrearJugador;
import co.com.sofka.bolera.jugador.events.JugadorCreado;
import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.bolera.partida.commands.CrearPartida;
import co.com.sofka.bolera.partida.events.PartidaCreada;
import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.bolera.partida.values.PartidaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.usecase.jugador.CrearJugadorUseCase;
import co.com.sofka.usecase.partida.CrearPartidaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearPartidaUseCaseTest {


    private CrearPartidaUseCase crearPartidaUseCase;
    @BeforeEach
    public void setup(){
        crearPartidaUseCase = new CrearPartidaUseCase();
    }

    @Test
    void crearPartidaHappyPath(){
        var command = new CrearPartida(
                PartidaId.of("xx"),
                new Capacidad(10)
        );

        var response = UseCaseHandler.getInstance().syncExecutor(
                crearPartidaUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        PartidaCreada partidaCreada = (PartidaCreada) events.get(0);
        Assertions.assertEquals("xx", partidaCreada.getPartidaId().value());
        Assertions.assertEquals(10, partidaCreada.getCapacidad().value());
    }
}
