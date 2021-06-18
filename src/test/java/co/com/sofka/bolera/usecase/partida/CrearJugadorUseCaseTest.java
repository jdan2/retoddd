package co.com.sofka.bolera.usecase.partida;

import co.com.sofka.bolera.jugador.commands.CrearJugador;
import co.com.sofka.bolera.jugador.events.JugadorCreado;
import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.usecase.jugador.CrearJugadorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CrearJugadorUseCaseTest {

    private CrearJugadorUseCase crearJugadorUseCase;
    @BeforeEach
    public void setup(){
        crearJugadorUseCase = new CrearJugadorUseCase();
    }

    @Test
    void crearJugadorHappyPath(){
        var command = new CrearJugador(
            JugadorId.of("xxxx"),
            new Nombre("Daniel"),
            new Email("daniel@gmail.com")
        );

        var response = UseCaseHandler.getInstance().syncExecutor(
                crearJugadorUseCase, new RequestCommand<>(command)
        ).orElseThrow();

       var events = response.getDomainEvents();

        JugadorCreado jugadorCreado = (JugadorCreado)events.get(0);
        Assertions.assertEquals("Daniel", jugadorCreado.getNombre().value());
        Assertions.assertEquals("daniel@gmail.com", jugadorCreado.getEmail().value());
    }
}
