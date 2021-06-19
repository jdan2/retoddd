package co.com.sofka.bolera.usecase.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.Membresia;
import co.com.sofka.bolera.jugador.commands.ActualizarPrecioDeMembresia;
import co.com.sofka.bolera.jugador.events.MembresiaCreada;
import co.com.sofka.bolera.jugador.events.PrecioDeMembresiaActualizado;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.ActualizarPrecioDeMembresiaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarPrecioDeMembresiaUseCaseTest {

    private ActualizarPrecioDeMembresiaUseCase actualizarPrecioDeMembresiaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarPrecioDeMembresiaUseCase = new ActualizarPrecioDeMembresiaUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarPrecioDeMembresiaUseCase.addRepository(repository);
    }
    @Test
    void actualizarPrecioDeMembresiaHappyPath(){
        var command = new ActualizarPrecioDeMembresia(
                MembresiaId.of("xx"),
                new Precio(30),
                JugadorId.of("xxx")
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(actualizarPrecioDeMembresiaUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        PrecioDeMembresiaActualizado precioDeMembresiaActualizado = (PrecioDeMembresiaActualizado)events.get(0);
        Assertions.assertEquals(30, precioDeMembresiaActualizado.getPrecio().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new MembresiaCreada( new Membresia(MembresiaId.of("xx"),new Precio(20), new Tipo("premiuin"), JugadorId.of("xxx"))),
                new PrecioDeMembresiaActualizado(MembresiaId.of("xx"), new Precio(40)));
    }
}
