package co.com.sofka.bolera.usecase.partida;

import co.com.sofka.bolera.generics.Tipo;
import co.com.sofka.bolera.jugador.commands.AgregarEquipamiento;
import co.com.sofka.bolera.jugador.events.EquipamientoAgregado;
import co.com.sofka.bolera.jugador.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.jugador.AgregarEquipamientoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarEquipamientoUseCaseTest {

    private AgregarEquipamientoUseCase agregarEquipamientoUseCase;
    private DomainEventRepository repository;
    @BeforeEach
    public void setup(){
        agregarEquipamientoUseCase = new AgregarEquipamientoUseCase();
        repository = mock(DomainEventRepository.class);
        agregarEquipamientoUseCase.addRepository(repository);
    }
    @Test
    void agregarEquipamientoHappyPath(){
        var command = new AgregarEquipamiento(
                EquipamientoId.of("xxx"),
                new Tipo("zapatos"),
                new Descripcion("Para Jugador"),
                JugadorId.of("xx")
        );

        when(repository.getEventsBy("xx")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx")
                .syncExecutor(agregarEquipamientoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        System.out.println(response);

        var events = response.getDomainEvents();

        EquipamientoAgregado equipamientoAgregado = (EquipamientoAgregado)events.get(0);
        Assertions.assertEquals("xxx", equipamientoAgregado.getEntityId().value());
        Assertions.assertEquals("zapatos", equipamientoAgregado.getTipo().value());
        Assertions.assertEquals("Para Jugador", equipamientoAgregado.getDescripcion().value());
    }

    private List<DomainEvent> events() {
        return List.of(new EquipamientoAgregado(
                EquipamientoId.of("xxx"),
                new Tipo("zapatos"),
                new Descripcion("Para Jugador"),
                JugadorId.of("xx")
        ));
    }

}