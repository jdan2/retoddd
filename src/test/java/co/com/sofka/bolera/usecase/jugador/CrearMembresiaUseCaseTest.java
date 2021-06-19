package co.com.sofka.bolera.usecase.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.Membresia;
import co.com.sofka.bolera.jugador.commands.CrearMembresia;
import co.com.sofka.bolera.jugador.events.MembresiaCreada;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.CrearMembresiaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearMembresiaUseCaseTest {

    private CrearMembresiaUseCase crearMembresiaUseCase;
    private DomainEventRepository repository;
    @BeforeEach
    public void setup(){
        crearMembresiaUseCase = new CrearMembresiaUseCase();
        repository = mock(DomainEventRepository.class);
        crearMembresiaUseCase.addRepository(repository);
    }

    @Test
    void crearMembresiaHappyPath(){
        var command = new CrearMembresia( new Membresia(
                MembresiaId.of("xxx"),
                new Precio(123),
                new Tipo("Premium"),
                JugadorId.of("xx")
        )
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(crearMembresiaUseCase, new RequestCommand<>(command))
                .orElseThrow();



        var events = response.getDomainEvents();

        MembresiaCreada membresiaCreada = (MembresiaCreada)events.get(0);
        Assertions.assertEquals("xx", membresiaCreada.getMembresia().jugadorId().value());
        Assertions.assertEquals(123, membresiaCreada.getMembresia().precio().value());
        Assertions.assertEquals("Premium", membresiaCreada.getMembresia().tipo().value());
    }

    private List<DomainEvent> events() {
        return List.of(new MembresiaCreada(
                new Membresia(
                        MembresiaId.of("xxx"),
                        new Precio(123),
                        new Tipo("Premium"),
                        JugadorId.of("xx")
                )
        ));
    }
}
