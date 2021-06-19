package co.com.sofka.bolera.usecase.partida;

import co.com.sofka.bolera.jugador.commands.ActualizarEmailDeJugador;
import co.com.sofka.bolera.jugador.commands.ActualizarNombreDeJugador;
import co.com.sofka.bolera.jugador.events.EmailDeJugadorActualizado;
import co.com.sofka.bolera.jugador.events.JugadorCreado;
import co.com.sofka.bolera.jugador.events.NombreDeJugadorActualizado;
import co.com.sofka.bolera.jugador.values.Email;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.ActualizarEmailDeJugadorUseCase;
import co.com.sofka.usecase.jugador.ActualizarNombreDeJugadorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarEmailDeJugadorUseCaseTest {

    private ActualizarEmailDeJugadorUseCase actualizarEmailDeJugadorUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarEmailDeJugadorUseCase = new ActualizarEmailDeJugadorUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarEmailDeJugadorUseCase.addRepository(repository);
    }
    @Test
    void actualizarEmailDeJugadorHappyPath(){
        var command = new ActualizarEmailDeJugador(
                JugadorId.of("xx"),
                new Email("pepa@gmail.com")
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(actualizarEmailDeJugadorUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        EmailDeJugadorActualizado emailDeJugadorActualizado = (EmailDeJugadorActualizado) events.get(0);
        Assertions.assertEquals("pepa@gmail.com", emailDeJugadorActualizado.getEmail().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new JugadorCreado(JugadorId.of("xx"),new Nombre("jugador"), new Email("pepitp@gmail.com")),
                new EmailDeJugadorActualizado(JugadorId.of("xx"), new Email("pepitp@gmail.com")));
    }
}
