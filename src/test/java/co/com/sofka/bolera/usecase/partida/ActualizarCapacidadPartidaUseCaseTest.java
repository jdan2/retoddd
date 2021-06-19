package co.com.sofka.bolera.usecase.partida;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.Membresia;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeMembresia;
import co.com.sofka.bolera.jugador.events.MembresiaCreada;
import co.com.sofka.bolera.jugador.events.TipoDeMembresiaActualizado;
import co.com.sofka.bolera.jugador.values.JugadorId;
import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.bolera.partida.commands.ActualizarCapacidadPartida;
import co.com.sofka.bolera.partida.events.CapacidadDePartidaActualizada;
import co.com.sofka.bolera.partida.events.PartidaCreada;
import co.com.sofka.bolera.partida.values.Capacidad;
import co.com.sofka.bolera.partida.values.PartidaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.ActualizarTipoDeMembresiaUseCase;
import co.com.sofka.usecase.partida.ActualizarCapacidadPartidaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarCapacidadPartidaUseCaseTest {

    private ActualizarCapacidadPartidaUseCase actualizarCapacidadPartidaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarCapacidadPartidaUseCase = new ActualizarCapacidadPartidaUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarCapacidadPartidaUseCase.addRepository(repository);
    }
    @Test
    void ActualizarCapacidadPartidaHappyPath(){
        var command = new ActualizarCapacidadPartida(
                PartidaId.of("xx"),
                new Capacidad(20)
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(actualizarCapacidadPartidaUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        CapacidadDePartidaActualizada capacidadDePartidaActualizada = (CapacidadDePartidaActualizada)events.get(0);
        Assertions.assertEquals(20, capacidadDePartidaActualizada.getCapacidad().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new PartidaCreada( PartidaId.of("xx"), new Capacidad(80)));
    }
}
