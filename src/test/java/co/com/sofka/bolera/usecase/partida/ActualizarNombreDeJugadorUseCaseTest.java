package co.com.sofka.bolera.usecase.partida;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.commands.ActualizarNombreDeJugador;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeEquipamiento;
import co.com.sofka.bolera.jugador.events.EquipamientoAgregado;
import co.com.sofka.bolera.jugador.events.JugadorCreado;
import co.com.sofka.bolera.jugador.events.NombreDeJugadorActualizado;
import co.com.sofka.bolera.jugador.events.TipoDeEquipamientoActualizado;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.ActualizarNombreDeJugadorUseCase;
import co.com.sofka.usecase.jugador.ActualizarTipoDeEquipamientoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarNombreDeJugadorUseCaseTest {

    private ActualizarNombreDeJugadorUseCase actualizarNombreDeJugadorUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarNombreDeJugadorUseCase = new ActualizarNombreDeJugadorUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarNombreDeJugadorUseCase.addRepository(repository);
    }
    @Test
    void actualizarNombreDeJugadorHappyPath(){
        var command = new ActualizarNombreDeJugador(
                JugadorId.of("xx"),
                new Nombre("pepasss")
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(actualizarNombreDeJugadorUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        NombreDeJugadorActualizado nombreDeJugadorActualizado = (NombreDeJugadorActualizado) events.get(0);
        Assertions.assertEquals("pepasss", nombreDeJugadorActualizado.getNombre().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new JugadorCreado(JugadorId.of("xx"),new Nombre("jugador"), new Email("pepitp@gmail.com")));
    }

}