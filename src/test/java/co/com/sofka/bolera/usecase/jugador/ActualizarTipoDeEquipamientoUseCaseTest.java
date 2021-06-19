package co.com.sofka.bolera.usecase.jugador;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeEquipamiento;
import co.com.sofka.bolera.jugador.events.EquipamientoAgregado;
import co.com.sofka.bolera.jugador.events.TipoDeEquipamientoActualizado;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.ActualizarTipoDeEquipamientoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ActualizarTipoDeEquipamientoUseCaseTest {

    private ActualizarTipoDeEquipamientoUseCase actualizarTipoDeEquipamientoUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarTipoDeEquipamientoUseCase = new ActualizarTipoDeEquipamientoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarTipoDeEquipamientoUseCase.addRepository(repository);
    }
    @Test
    void actualizarTipoEquipamientoHappyPath(){
        var command = new ActualizarTipoDeEquipamiento(
                EquipamientoId.of("xxx"),
                new Tipo("zapatos"),
                JugadorId.of("xx")
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(actualizarTipoDeEquipamientoUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        TipoDeEquipamientoActualizado tipoDeEquipamientoActualizado = (TipoDeEquipamientoActualizado)events.get(0);
        Assertions.assertEquals("zapatos", tipoDeEquipamientoActualizado.getTipo().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new EquipamientoAgregado(EquipamientoId.of("xxx"),new Tipo("zapatos"), new Descripcion("paraaaa"), JugadorId.of("xx")),
                new TipoDeEquipamientoActualizado(EquipamientoId.of("xxx"), new Tipo("ZAPATOS")));
    }

}