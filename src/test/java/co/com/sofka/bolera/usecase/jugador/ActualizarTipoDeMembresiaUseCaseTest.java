package co.com.sofka.bolera.usecase.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.Membresia;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeMembresia;
import co.com.sofka.bolera.jugador.events.MembresiaCreada;
import co.com.sofka.bolera.jugador.events.TipoDeMembresiaActualizado;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.ActualizarTipoDeMembresiaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarTipoDeMembresiaUseCaseTest {

    private ActualizarTipoDeMembresiaUseCase actualizarTipoDeMembresiaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarTipoDeMembresiaUseCase = new ActualizarTipoDeMembresiaUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarTipoDeMembresiaUseCase.addRepository(repository);
    }
    @Test
    void setActualizarTipoDeMembresiaHappyPath(){
        var command = new ActualizarTipoDeMembresia(
                MembresiaId.of("xxx"),
                new Tipo("Premium"),
                JugadorId.of("xx")
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(actualizarTipoDeMembresiaUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        TipoDeMembresiaActualizado tipoDeMembresiaActualizado = (TipoDeMembresiaActualizado)events.get(0);
        Assertions.assertEquals("Premium", tipoDeMembresiaActualizado.getTipo().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new MembresiaCreada( new Membresia(MembresiaId.of("xx"),new Precio(20), new Tipo("Premim"), JugadorId.of("xxx"))),
                new TipoDeMembresiaActualizado(MembresiaId.of("xxx"), new Tipo("Premim2")));
    }
}
